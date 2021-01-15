package com.li.action.cateaction;

import com.li.po.CateGory;
import com.li.sercive.categorysercive.CateGorySercive;
import com.li.sercive.categorysercive.Impl.CateGorySerciveImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "*.cate")
public class CateAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理编码
        String code ="UTF-8";
        request.setCharacterEncoding(code);
        response.setContentType("text/html;charset="+code);
        PrintWriter out =response.getWriter();

        String uri=request.getRequestURI();
        String url=uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."));
        //先创建业务层对象
        CateGorySercive cateGorySercive=new CateGorySerciveImpl();

        if ("query".equals(url)){
            //查询分类
            //调用业务层 没有设置条件
            List<CateGory> list=cateGorySercive.queryClass(null);
            //存入session中
            HttpSession session=request.getSession();
            session.setAttribute("catelist",list);
            //转发
            request.getRequestDispatcher("/manage/cate.jsp").forward(request,response);

        }else if ("add".equals(url)){
            //添加分类
            //获取分类名称和所属父分类
            String cateName=request.getParameter("cateName");
            String catePid=request.getParameter("parentId");
            //调用业务层添加分类
            int i=cateGorySercive.addCate(cateName,Integer.parseInt(catePid));
            //判断是否添加成功
            if (i>0){
                //添加成功
                out.write("<script>");
                out.write("alert('添加成功');");
                out.write("location.href='/EmsDemo_war_exploded/query.cate';");
                out.write("</script>");
            }else{
                //添加失败
                out.write("<script>");
                out.write("alert('添加失败');");
                out.write("location.href='/EmsDemo_war_exploded/query.cate';");
                out.write("</script>");
            }

        }else if ("findcatebyid".equals(url)){
            //查找cate
            //获取id
            String idStr=request.getParameter("id");
            //调用业务层
            CateGory cateGory=cateGorySercive.findCateById(Integer.parseInt(idStr));
            //存入request
            request.setAttribute("cate1",cateGory);
            //转发
            request.getRequestDispatcher("/manage/cateupdate.jsp").forward(request,response);
        }else if ("update".equals(url)){
            //修改分类
            //获取分类id
            String cateId=request.getParameter("id");
            //获取新分类名称
            String cateName=request.getParameter("cateName");
            //获取分类父id
            String cateParentId=request.getParameter("parentId");
            //存到分类实体
            CateGory cateGory=new CateGory(Integer.parseInt(cateId),cateName,Integer.parseInt(cateParentId));
            //调用业务层
            int i=cateGorySercive.updateCate(cateGory);
            if (i>0){
                //修改成功
                out.write("<script>");
                out.write("alert('修改成功');");
                out.write("location.href='/EmsDemo_war_exploded/query.cate';");
                out.write("</script>");
            }else{
                //修改失败
                out.write("<script>");
                out.write("alert('修改失败');");
                out.write("location.href='/EmsDemo_war_exploded/query.cate';");
                out.write("</script>");
            }

        }else if ("delete".equals(url)){
            //删除分类
            //获得id
            String idStr=request.getParameter("id");
            //调用业务层 找到该分类的实体
            CateGory cateGory=cateGorySercive.findCateById(Integer.parseInt(idStr));
            //判断是否是夫分类
            if (cateGory.getCateParentId()==0){
                //是夫分类，如果有子分类则不能删除，查询是否有子分类
                int count=cateGorySercive.queryCateCount(Integer.parseInt(idStr));
                if (count==0){
                    //子分类数量位0可以删除
                    int i=cateGorySercive.deleteCate(Integer.parseInt(idStr));
                    if (i>0){
                        out.write("<script>");
                        out.write("alert('删除成功');");
                        out.write("location.href='/EmsDemo_war_exploded/query.cate';");
                        out.write("</script>");
                    }else{
                        out.write("<script>");
                        out.write("alert('删除失败');");
                        out.write("location.href='/EmsDemo_war_exploded/query.cate';");
                        out.write("</script>");
                    }

                }else{
                    //子分类数量不为0 不能删除
                    out.write("<script>");
                    out.write("alert('删除失败');");
                    out.write("location.href='/EmsDemo_war_exploded/query.cate';");
                    out.write("</script>");
                }
            }else{
                //为子分类 ，判断是否有商品 有则不能删除 。。 这里直接删除
                int i=cateGorySercive.deleteCate(Integer.parseInt(idStr));
                if (i>0){
                    out.write("<script>");
                    out.write("alert('删除成功');");
                    out.write("location.href='/EmsDemo_war_exploded/query.cate';");
                    out.write("</script>");
                }else{
                    out.write("<script>");
                    out.write("alert('删除失败');");
                    out.write("location.href='/EmsDemo_war_exploded/query.cate';");
                    out.write("</script>");
                }
            }

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
