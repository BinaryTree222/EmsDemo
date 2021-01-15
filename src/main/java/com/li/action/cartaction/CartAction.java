package com.li.action.cartaction;

import com.li.po.Cart;
import com.li.po.Product;
import com.li.po.User;
import com.li.sercive.cartsercive.CartSercive;
import com.li.sercive.cartsercive.Impl.CartSerciveImpl;
import com.li.sercive.categorysercive.CateGorySercive;
import com.li.sercive.categorysercive.Impl.CateGorySerciveImpl;
import com.li.sercive.productsercive.Impl.ProductSerciveImpl;
import com.li.sercive.productsercive.ProductSercive;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "*.cart")
public class CartAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理编码
        String code = "UTF-8";
        request.setCharacterEncoding(code);
        response.setContentType("text/html;charset=" + code);
        PrintWriter out = response.getWriter();

        String uri = request.getRequestURI();
        String url = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
        //先创建业务层对象
        //创建产品业务层对象
        ProductSercive productSercive = new ProductSerciveImpl();
        //创建购物车业务层对象
        CartSercive cartSercive = new CartSerciveImpl();

        if ("toaddcart".equals(url)) {
            //添加到购物车
            String pid = request.getParameter("id");
            int pidint=Integer.parseInt(pid);
            String q  = request.getParameter("q");
            String flag = request.getParameter("flag");
            //找到该产品 先创建购物车
            Product product = productSercive.findProductById(Integer.parseInt(pid));
            //如果数量超过库存则不能添加
            if (Integer.parseInt(q) > product.getpCount()) {
                out.write("<script>");
                out.write("alert('数量超过库存');");
                out.write("location.href='/EmsDemo_war_exploded/todetail.pro?id= " + Integer.parseInt(pid) + "';");
                out.write("</script>");
            }
            //创建购物车对象
            Cart cart = new Cart("0",
                    Integer.parseInt(pid),
                    product.getpPfilename(),
                    Integer.parseInt(q),
                    product.getpCount(),
                    product.getpName(),
                    product.getpPrice(),
                    1
            );
            //找到用户
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

            if (flag.equals("1")) {
                //立即购买
                //判断是否登录
                if (user != null) {
                    //登录了 添加到购物车
                    cart.setCartUid(user.getUserId());
                    //查询该用户是否有该产品的购物车 有则修改数量,没有添加新的购物车
                    Cart cart1=cartSercive.queryCartByUidAndPid( user.getUserId(), pidint);
                    int i=0;
                    if (cart1!=null){
                        //修改数量
                        cart1.setCartPQuantity(cart1.getCartPQuantity()+Integer.parseInt(q));
                        i=cartSercive.updateCartCount(cart1);

                    }else{
                        //添加到数据库
                        i = cartSercive.cartAdd(cart);
                    }

                    if (i > 0) {
                        //添加成功
                        //把用户的所有订单查询出来 转发购物车界面
                        List<Cart> list = cartSercive.queryCartByUid(user.getUserId());
                        request.setAttribute("carts", list);
                        request.getRequestDispatcher("/cart.jsp").forward(request, response);

                    } else {
                        String path ="location.href='/EmsDemo_war_exploded/todetail.pro?id="+ pid+"';";
                        //添加失败
                        out.write("<script>");
                        out.write("alert('添加失败');");
                        out.write(path);
                        out.write("</script>");
                    }

                } else {
                    //没登陆
                    out.write("<script>");
                    out.write("alert('请登录');");
                    out.write("location.href='/EmsDemo_war_exploded/login.jsp';");
                    out.write("</script>");
                }

            } else {
                //添加到购物车
                if (user != null) {
                    //cart加到数据库不跳转回详情界面
                    //登录了 添加到购物车
                    cart.setCartUid(user.getUserId());
                    //查询该用户是否有该产品的购物车 有则修改数量,没有添加新的购物车
                    Cart cart1=cartSercive.queryCartByUidAndPid( user.getUserId(), pidint);
                    int i=0;
                    if (cart1!=null){
                        //修改数量
                        cart1.setCartPQuantity(cart1.getCartPQuantity()+Integer.parseInt(q));
                        i=cartSercive.updateCartCount(cart1);

                    }else{
                        //添加到数据库
                        i = cartSercive.cartAdd(cart);
                    }
                    if (i > 0) {
                        String path ="location.href='/EmsDemo_war_exploded/todetail.pro?id="+ pid+"';";

                        //添加成功
                        out.write("<script>");
                        out.write("alert('添加成功');");
                        out.write(path);
                        out.write("</script>");
                    } else {
                        //添加失败
                        String path ="location.href='/EmsDemo_war_exploded/todetail.pro?id="+ pid+"';";

                        out.write("<script>");
                        out.write("alert('添加失败');");
                        out.write(path);
                        out.write("</script>");
                    }

                } else {
                    //没登录
                    out.write("<script>");
                    out.write("alert('请登录');");
                    out.write("location.href='/EmsDemo_war_exploded/login.jsp';");
                    out.write("</script>");
                }
            }
        }else if ("tocart".equals(url)){
            //去购物车
            //判断是否登录
            HttpSession session=request.getSession();
            User user=(User)session.getAttribute("user");
            if (user!=null){
                //查询用户的cart购物车
                List<Cart> carts=cartSercive.queryCartByUid(user.getUserId());
                //跳转到购物车页面
                request.setAttribute("carts",carts);
                request.getRequestDispatcher("/cart.jsp").forward(request,response);
            }else {
                //没登陆
                out.write("<script>");
                out.write("alert('请登录');");
                out.write("location.href='/EmsDemo_war_exploded/login.jsp';");
                out.write("</script>");
            }
        }else if("tochangecartcount".equals(url)){
            //设置购物车的数量
            //获取购物车id和数量
            String cartId=request.getParameter("id");
            String q=request.getParameter("q");
            if (cartId!=null){
                //根据id查询购物车
                 Cart cart=cartSercive.findCartById(Integer.parseInt(cartId));
                 //查询产品的最大数量
                 Product product=productSercive.findProductById(cart.getCartPid());
                 //判断数量
                 int qInt=Integer.parseInt(q);
                 if (qInt>0  && qInt<= product.getpCount()){
                    cart.setCartPQuantity(qInt);
                 }
            }
        }else if("todelete".equals(url)){
            //删除cart
            String cartId =request.getParameter("id");
            int i=0;
            if (cartId!=null){
               i= cartSercive.deleteCart(Integer.parseInt(cartId));
            }
        }else  if ("toorder".equals(url)){
            //去结算购物车
            //判断登录
            HttpSession session=request.getSession();
            User user=(User)session.getAttribute("user");
            if (user!=null){
                //一登陆
                String ids=request.getParameter("ids");
                if (ids!=null){
                  String[] idss =  ids.split(",");
                  List<Cart> list=new ArrayList<Cart>();
                  double money=0;
                  for (String id: idss){
                      Cart cart=cartSercive.findCartById(Integer.parseInt(id));
                      list.add(cart);
                      //计算总金额
                      money+=cart.getCartPQuantity()*cart.getCartPPrice();

                  }
                 request.setAttribute("lc",list);
                  //保留2位
                    DecimalFormat df=new DecimalFormat("#.00");
                  request.setAttribute("money",df.format(money));
                  request.getRequestDispatcher("/order.jsp").forward(request,response);
                }
            }else{
                //未登录
                out.write("<script>");
                out.write("alert('请登录');");
                out.write("location.href='/EmsDemo_war_exploded/login.jsp';");
                out.write("</script>");
            }

        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
