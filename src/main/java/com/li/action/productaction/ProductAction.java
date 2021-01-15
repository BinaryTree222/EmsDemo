package com.li.action.productaction;

import com.li.po.CateGory;
import com.li.po.Product;
import com.li.po.User;
import com.li.sercive.categorysercive.CateGorySercive;
import com.li.sercive.categorysercive.Impl.CateGorySerciveImpl;
import com.li.sercive.productsercive.Impl.ProductSerciveImpl;
import com.li.sercive.productsercive.ProductSercive;
import com.li.utils.PageInfo;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "*.pro")
public class ProductAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理编码
        String code ="UTF-8";
        request.setCharacterEncoding(code);
        response.setContentType("text/html;charset="+code);
        PrintWriter out =response.getWriter();

        String uri=request.getRequestURI();
        String url=uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."));
        //创建业务层对象
        ProductSercive productSercive=new ProductSerciveImpl();
        if ("toadd".equals(url)){
            //查询产品的分类到产品添加页面
            //创建分类业务层
            CateGorySercive cateGorySercive=new CateGorySerciveImpl();
            //查询所有分类
            List<CateGory> list=cateGorySercive.queryClass(null);
            //存入request
            request.setAttribute("allcate",list);
            //转发
            request.getRequestDispatcher("/manage/productadd.jsp").forward(request,response);
        } else if ("add".equals(url)) {
            //添加产品
            //创建产品实列
            Product product=new Product();
            //获取参数
            //是否有文件上传
            if (ServletFileUpload.isMultipartContent(request)){
                List<FileItem> items=null;
                try {
                    //得到一个文件上传缓冲
                    FileItemFactory factory=new DiskFileItemFactory();
                    //创建一个文件上传对象
                    ServletFileUpload upload=new ServletFileUpload(factory);
                    //得到请求参数
                     items=upload.parseRequest(request);
                } catch (FileUploadException e) {
                    e.printStackTrace();
                }
                //遍历
                for(FileItem item:items){
                    //判断是否是表单项
                    if (item.isFormField()){
                        //得到表单项的name属性
                        String name=item.getFieldName();
                        if (name.equals("pName")){
                            //是产品名
                            product.setpName(item.getString("UTF-8"));
                        }else if(name.equals("pDes")){
                            //产品描述
                            product.setpDes(item.getString("UTF-8"));
                        }else if (name.equals("price")){
                            //产品价格
                            product.setpPrice(Double.parseDouble(item.getString("UTF-8")));
                        }else  if (name.equals("count")){
                            //产品数量
                            product.setpCount(Integer.parseInt(item.getString("UTF-8")));
                        }else if (name.equals("parentId")){
                            String value=item.getString("UTF-8");
                            String id=value.substring(0,value.lastIndexOf("-"));
                            String pId=value.substring(value.lastIndexOf("-")+1);
                            //如果一级分类有子类，则不能直接插入一级分类，否则可以
                            if (pId.equals("null")){//父类
                                //直接插入一级分类则要检查是否有子类，有则不能插入
                                CateGorySercive cateGorySercive=new CateGorySerciveImpl();
                                int count =cateGorySercive.queryCateCount(Integer.parseInt(id));
                                if (count>0){
                                    //插入失败
                                    out.write("<script>");
                                    out.write("alert('不能直接插入一级父类');");
                                    out.write("location.href='/EmsDemo_war_exploded/manage/product.jsp';");
                                    out.write("</script>");
                                }
                            }
                            //设置产品类
                            product.setpCate1(Integer.parseInt(id));
                            if (pId.equals("null")){
                                product.setpCate2(0);
                            }else{
                                product.setpCate2(Integer.parseInt(pId));
                            }

                        }

                    }else {
                        //不是表单项
                        //拿到文件名
                        String fileName=item.getName();
                        product.setpPfilename(fileName);
                        //定义存储路径
                        String path = "F:\\EmsDemo\\src\\main\\webapp\\img\\product";
                        try {
                            item.write(new File(path,fileName));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            //调用业务层
            int i=productSercive.addProduct(product);
            if (i>0){
                //添加成功
                out.write("<script>");
                out.write("alert('添加成功');");
                out.write("location.href='/EmsDemo_war_exploded/querypage.pro';");
                out.write("</script>");
            }else{
                //添加失败
                out.write("<script>");
                out.write("alert('添加失败');");
                out.write("location.href='/EmsDemo_war_exploded/manage/productadd.jsp';");
                out.write("</script>");
            }

        }else if ("querypage".equals(url)){
            //分页查询
            //获取当前页
            String idStr=request.getParameter("curPageNo");
            Integer id=1;
            if (idStr!= null) {
                //转化位数字
                id=Integer.parseInt(idStr);
            }
            //创建页数对象
            PageInfo pageInfo=new PageInfo();
            //存入当前页
            pageInfo.setCurPageNo(id);
            //获得总条数 有条件就设置user
            int count=productSercive.getTotalCount(null);
            //存入总条数 设置总页数
            pageInfo.setTotalCount(count);
            //存入request
            request.setAttribute("pageinfo",pageInfo);
            //分页查询
            List<Product> list=productSercive.queryPage(pageInfo,null);
            //存入request
            request.setAttribute("prolist",list);
            //存入url
            String url1=url+".pro";
            request.setAttribute("url",url1);
            //转发
            request.getRequestDispatcher("/manage/product.jsp").forward(request,response);
        }else if ("findproductebyid".equals(url)){
            //通过id找到产品
            String id= request.getParameter("id");
            //查询该产品
            Product product=productSercive.findProductById(Integer.parseInt(id));
            //存入request 转发
            request.setAttribute("product",product);
            //查询分类 再转发
           CateGorySercive cateGorySercive=new CateGorySerciveImpl();
            List<CateGory> list=cateGorySercive.queryClass(null);
            request.setAttribute("allcate",list);
            //转发
            request.getRequestDispatcher("/manage/productupdate.jsp").forward(request,response);
        }else if ("update".equals(url)){
            //修改product
            //创建产品实列
            Product product=new Product();
            //获取参数
            //是否有文件上传
            if (ServletFileUpload.isMultipartContent(request)){
                List<FileItem> items=null;
                try {
                    //得到一个文件上传缓冲
                    FileItemFactory factory=new DiskFileItemFactory();
                    //创建一个文件上传对象
                    ServletFileUpload upload=new ServletFileUpload(factory);
                    //得到请求参数
                    items=upload.parseRequest(request);
                } catch (FileUploadException e) {
                    e.printStackTrace();
                }
                //遍历
                for(FileItem item:items){
                    //判断是否是表单项
                    if (item.isFormField()){
                        //得到表单项的name属性
                        String name=item.getFieldName();
                        if (name.equals("pName")){
                            //是产品名
                            product.setpName(item.getString("UTF-8"));
                        }else if(name.equals("pDes")){
                            //产品描述
                            product.setpDes(item.getString("UTF-8"));
                        }else if (name.equals("price")){
                            //产品价格
                            product.setpPrice(Double.parseDouble(item.getString("UTF-8")));
                        }else  if (name.equals("count")){
                            //产品数量
                            product.setpCount(Integer.parseInt(item.getString("UTF-8")));
                        }else if (name.equals("parentId")){
                            String value=item.getString("UTF-8");
                            String id=value.substring(0,value.lastIndexOf("-"));
                            String pId=value.substring(value.lastIndexOf("-")+1);
                            //如果一级分类有子类，则不能直接插入一级分类，否则可以
                            if (pId.equals("null")){//父类
                                //直接插入一级分类则要检查是否有子类，有则不能插入
                                CateGorySercive cateGorySercive=new CateGorySerciveImpl();
                                int count =cateGorySercive.queryCateCount(Integer.parseInt(id));
                                if (count>0){
                                    //插入失败
                                    out.write("<script>");
                                    out.write("alert('不能直接插入一级父类');");
                                    out.write("location.href='/EmsDemo_war_exploded/manage/product.jsp';");
                                    out.write("</script>");
                                }
                            }
                            //设置产品类
                            product.setpCate1(Integer.parseInt(id));
                            if (pId.equals("null")){
                                product.setpCate2(0);
                            }else{
                                product.setpCate2(Integer.parseInt(pId));
                            }

                        }else if (name.equals("id")){
                            product.setpId(Integer.parseInt(item.getString("UTF-8")));
                        }

                    }else {
                        //不是表单项
                        //拿到文件名
                        String fileName=item.getName();
                        product.setpPfilename(fileName);
                        //定义存储路径
                        String path = "F:\\EmsDemo\\src\\main\\webapp\\img\\product";
                        try {
                            item.write(new File(path,fileName));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            //调用业务层
            int i=productSercive.updateProduct(product);
            if (i>0){
                //修改成功
                out.write("<script>");
                out.write("alert('修改成功');");
                out.write("location.href='/EmsDemo_war_exploded/querypage.pro';");
                out.write("</script>");
            }else{
                //修改失败
                out.write("<script>");
                out.write("alert('修改失败');");
                out.write("location.href='/EmsDemo_war_exploded/querypage.pro';");
                out.write("</script>");
            }
        }else if ("todetail".equals(url)){
            //获得产品id
            String id=request.getParameter("id");
            //查询产品
            Product product=productSercive.findProductById(Integer.parseInt(id));
            //存入requeset
            request.setAttribute("p1",product);
            //查询所属分类
            CateGorySercive cateGorySercive=new CateGorySerciveImpl();
            //找到分类
            CateGory cateGory=cateGorySercive.findCateById(product.getpCate1());
            if (product.getpCate2()!=0){
                //有父类 找到父类
                CateGory cateGory1=cateGorySercive.findCateById(product.getpCate2());
                request.setAttribute("pcate1",cateGory1);
                request.setAttribute("ccate1",cateGory);

            }else{
                //没有父类，则为父类
                request.setAttribute("pcate1",cateGory);
            }
            //为你推荐 查询同类产品
            CateGory cateGory2=new CateGory();
            cateGory2.setCateId(product.getpCate1());
            cateGory2.setCateParentId(product.getpCate2());
            List<Product> list=productSercive.queryProductByCate(cateGory2);
            request.setAttribute("likelist",list);

            //获取最近访问
            //获取session对象
            HttpSession session=request.getSession();
            //从session中获取ids
            ArrayList<Integer> ids=(ArrayList<Integer>)session.getAttribute("ids");
            if (ids==null){
                ids=new ArrayList<Integer>();
                session.setAttribute("ids",ids);
            }
//          //放5个
            if (ids.size()>5){
                ids.remove(0);
            }
            //id不等于null 并且ids不包含该id
            if (id!=null&& !(ids.contains(Integer.parseInt(id)))){
                ids.add(Integer.parseInt(id));
                session.setAttribute("ids",ids);
            }
            //从ids中取出id存入list中
            List<Product> recentList=new ArrayList<Product>();
            for (Integer id2:ids ){
                recentList.add(productSercive.findProductById(id2));
            }
            request.setAttribute("recentlist",recentList);
            //转发
            request.getRequestDispatcher("/proDetail.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
