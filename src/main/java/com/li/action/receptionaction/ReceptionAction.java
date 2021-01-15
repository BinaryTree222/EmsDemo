package com.li.action.receptionaction;

import com.li.po.CateGory;
import com.li.po.Product;
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
import java.util.List;

@WebServlet(urlPatterns = "*.rec")
public class ReceptionAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理编码
        String code ="UTF-8";
        request.setCharacterEncoding(code);
        response.setContentType("text/html;charset="+code);
        PrintWriter out =response.getWriter();

        String uri=request.getRequestURI();
        String url=uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."));

        if ("loadindex".equals(url)){
            //加载首页
            //1.加载首页分类
            CateGorySercive cateGorySercive=new CateGorySerciveImpl();
            List<CateGory> list=cateGorySercive.queryClass(null);
            //存入session
            HttpSession session =request.getSession();
            session.setAttribute("listofcate",list);
            //从数据库中取出
            ProductSercive productSercive=new ProductSerciveImpl();
            List<Product> list1=productSercive.queryProductByCate(null);
            //存入request
            session.setAttribute("listindex",list1);
            //转发到网站首页
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }else if ("tocate".equals(url)){
            //通过分类id找到到分类的内容
            String idStr=request.getParameter("id");
            //调用业务层，找到分类实体
            CateGorySercive cateGorySercive=new CateGorySerciveImpl();
            CateGory cateGory=cateGorySercive.findCateById(Integer.parseInt(idStr));
            //找到属于该类的内容
            ProductSercive productSercive=new ProductSerciveImpl();
            List<Product>list=productSercive.queryProductByCate(cateGory);
            //存入request
            request.setAttribute("aftercatelist",list);
            //跳转到前台所属页面
            if (cateGory.getCateName().equals("装饰摆件")){
                request.getRequestDispatcher("/flowerDer.jsp").forward(request,response);
            }else if (cateGory.getCateName().equals("千花花艺")){
                request.getRequestDispatcher("/proList.jsp").forward(request,response);
            }else if (cateGory.getCateName().equals("花瓶花器")){
                request.getRequestDispatcher("/vase_proList.jsp").forward(request,response);
            }else if (cateGory.getCateName().equals("布艺软饰")){
                request.getRequestDispatcher("/decoration.jsp").forward(request,response);
            }else if (cateGory.getCateName().equals("桌布罩件")){
                request.getRequestDispatcher("/zbproList.jsp").forward(request,response);
            }else if (cateGory.getCateName().equals("抱枕靠垫")){
                request.getRequestDispatcher("/bzproList.jsp").forward(request,response);
            }else if (cateGory.getCateName().equals("墙式壁挂")){
                request.getRequestDispatcher("/paint.jsp").forward(request,response);
            }else if (cateGory.getCateName().equals("蜡艺熏香")){
                request.getRequestDispatcher("/perfume.jsp").forward(request,response);
            }else if (cateGory.getCateName().equals("创意家居")){
                request.getRequestDispatcher("/idea.jsp").forward(request,response);
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
