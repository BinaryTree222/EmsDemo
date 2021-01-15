package com.li.action.useraction;

        import com.li.po.User;
        import com.li.sercive.userSercive.Impl.UserSerciveImpl;
        import com.li.sercive.userSercive.UserSercive;
        import com.li.utils.PageInfo;


        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.servlet.http.HttpSession;
        import java.io.IOException;

        import java.io.PrintWriter;
        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.Date;
        import java.util.List;


@WebServlet(urlPatterns = "*.user")
public class UserAction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理编码
        String code ="UTF-8";
        req.setCharacterEncoding(code);
        resp.setContentType("text/html;charset="+code);
        PrintWriter out =resp.getWriter();

        String uri=req.getRequestURI();
        String url=uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."));
       //创建业务层对象
        UserSercive userSercive = new UserSerciveImpl();
        //根据url执行业务
        if ("add".equals(url)) {
            //添加用户
            //获取值
            String uesrName = req.getParameter("userName");
            String name = req.getParameter("name");
            String pwd = req.getParameter("passWord");
            String repwd = req.getParameter("repassWord");
            String sex = req.getParameter("sex");
            String birthday = req.getParameter("birthday");
            String mobile = req.getParameter("mobile");
            String email = req.getParameter("email");
            String address = req.getParameter("address");
            //创建实体
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = s.parse(birthday);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            User user = new User(uesrName, name, pwd, sex, date, email, mobile, address, 1);
            //调用业务层

            int i = userSercive.addUser(user);
            //判断是否成功
            if (i > 0) {
                //添加成功 用户管理界面
                out.write("<script>");
                out.write("alert('操作成功');");
                out.write("location.href='manage/index.jsp';");
                out.write("</script>");
            } else {
                //添加失败 用户管理界面
                out.write("<script>");
                out.write("alert('操作失败');");
                out.write("location.href='manage/index.jsp';");
                out.write("</script>");
            }
        }else if("querypage".equals(url)){
            //分页查询
            //获取当前页
            String idStr=req.getParameter("curPageNo");
            Integer id=1;
            if (idStr!= null) {
                //转化位数字
                id=Integer.parseInt(idStr);
            }
            //创建页数对象
            PageInfo pageInfo=new PageInfo();
            //存入当前页
            pageInfo.setCurPageNo(id);
            //获得总页数 有条件就设置user
            User user=new User();
            int count=userSercive.getPageCount(user);
            //存入总条数
            pageInfo.setTotalCount(count);
            //调用业务层
            List<User> list=userSercive.queryPage(pageInfo,user);
            //存入list
            req.setAttribute("list",list);
            //存入url
            String url1="querypage.user";
            req.setAttribute("url",url1);
            //存入页码信息
            req.setAttribute("pageinfo",pageInfo);
            //转发
            req.getRequestDispatcher("/manage/design.jsp").forward(req,resp);
        }else if ("search".equals(url)){
            //获取收索条件
            String keyWords=req.getParameter("keywords");
            //获取当前页
            String idStr=req.getParameter("curPageNo");
            Integer id=1;
            if (idStr!= null) {
                //转化位数字
                id=Integer.parseInt(idStr);
            }
            //创建页数对象
            PageInfo pageInfo=new PageInfo();
            //存入当前页
            pageInfo.setCurPageNo(id);
            //获得总页数 有条件就设置user
            User user=new User();
            user.setUserId(keyWords);
            int count=userSercive.getPageCount(user);
            //存入总条数
            pageInfo.setTotalCount(count);
            //调用业务层
            List<User> list=userSercive.queryPage(pageInfo,user);
            //存入list
            req.setAttribute("list",list);
            //存入url
            String url1="search.user";
            req.setAttribute("url",url1);
            //存入页码信息
            req.setAttribute("pageinfo",pageInfo);
            //转发
            req.getRequestDispatcher("/manage/design.jsp").forward(req,resp);

        }else if ("finduserbyid".equals(url)){
            //获取id
            String id=req.getParameter("id");
            //调用业务层
            User user=userSercive.findUserById(id);
            //判断是否有值
            if (user!=null){
                //有值
                req.setAttribute("user",user);
                //转发到修改页面
                req.getRequestDispatcher("/manage/update.jsp").forward(req,resp            );
            }else{
                //无值 重定向到用户管理界面
                resp.sendRedirect("/querypage.user");
            }
        }else if ("update".equals(url)){
            //修改用户
            //获取值
            String uesrName = req.getParameter("userName");
            String name = req.getParameter("name");
            String pwd = req.getParameter("passWord");
            String repwd = req.getParameter("repassWord");
            String sex = req.getParameter("sex");
            String birthday = req.getParameter("birthday");
            String mobile = req.getParameter("mobile");
            String email = req.getParameter("email");
            String address = req.getParameter("address");
            //创建实体
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = s.parse(birthday);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            User user = new User(uesrName, name, pwd, sex, date, email, mobile, address, 1);
            //调用业务层
            int i = userSercive.updateUser(user);
            //判断是否成功
            if (i>0){
                //修改成功 跳到用户管理界面
                out.write("<script>");
                out.write("alert('操作成功');");
                out.write("location.href='manage/index.jsp';");
                out.write("</script>");
            }else{
                //修改失败跳到 用户管理界面
                out.write("<script>");
                out.write("alert('操作失败');");
                out.write("location.href='manage/index.jsp';");
                out.write("</script>");
            }

        }else if ("delete".equals(url)){
            //获取id
            String id =req.getParameter("id");
            //调用业务层
            int i=userSercive.deleteUser(id);
            if (i>0){
                //删除成功
                out.write("<script>");
                out.write("alert('操作成功');");
                out.write("location.href='manage/index.jsp';");
                out.write("</script>");


            }else{
                //删除失败
                out.write("<script>");
                out.write("alert('操作失败');");
                out.write("location.href='manage/index.jsp';");
                out.write("</script>");
            }
        }else if ("checkname".equals(url)){
            //注册时检查用户名
            //获取用户名
            String userName=req.getParameter("name");
            //调用业务层
            int i=userSercive.checkUserName(userName);
            //判断是否有值
            if (i>0){
                //用户名已存在
                out.println(1);
            }else{
                //用户名可以使用
                out.println(2);
            }
        }else if ("reg".equals(url)){
            //注册用户
            //获取值
            String uesrName = req.getParameter("userName");
            String name = req.getParameter("name");
            String pwd = req.getParameter("passWord");
            String repwd = req.getParameter("repassWord");
            String sex = req.getParameter("sex");
            String birthday = req.getParameter("birthday");
            String mobile = req.getParameter("mobile");
            String email = req.getParameter("email");
            String address = req.getParameter("address");
            //创建实体
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = s.parse(birthday);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            User user = new User(uesrName, name, pwd, sex, date, email, mobile, address, 1);
            //调用业务层
            int i = userSercive.addUser(user);
            //判断是否成功
            if (i > 0) {
                //注册成功 登录界面
                out.write("<script>");
                out.write("alert('注册成功');");
                out.write("location.href='login.jsp';");
                out.write("</script>");
            } else {
                //注册失败 注册界面
                out.write("<script>");
                out.write("alert('注册失败');");
                out.write("location.href='reg.jsp';");
                out.write("</script>");
            }

        }else if ("login".equals(url)){
            //获取用户名和密码
            String userName=req.getParameter("userName");
            String pwd=req.getParameter("pWd");
            //调用业务层
            User user=userSercive.login(userName,pwd);
            //判断是否存在用户
            if (user !=null){
                //用户存在 存入Seesion
                HttpSession session =req.getSession();
                session.setAttribute("user",user);
                req.getRequestDispatcher("/index.jsp").forward(req,resp);
            }else{
                //用户不存在
                out.write("<script>");
                out.write("alert('登录失败');");
                out.write("location.href='login.jsp';");
                out.write("</script>");
            }
        }else if ("loginbackstage".equals(url)){
            //后台登录
            //获取用户名和密码
            String userName=req.getParameter("username");
            String pwd=req.getParameter("pwd");
            //调用业务层
            User user=userSercive.loginBack(userName,pwd);
            //判断是否存在管理员用户
            if (user !=null){
                //用户存在 存入Seesion
                HttpSession session =req.getSession();
                session.setAttribute("superuser",user);
                req.getRequestDispatcher("/manage/index.jsp").forward(req,resp);
            }else{
                //用户不存在
                out.write("<script>");
                out.write("alert('登录失败');");
                out.write("location.href='/manage/login.jsp';");
                out.write("</script>");
            }
        }else if ("excitback".equals(url)){
            //退出后台
            HttpSession session=req.getSession();
            session.removeAttribute("superuser");
            //退出成功
            out.write("<script>");
            out.write("alert('退出成功');");
            out.write("location.href='/EmsDemo_war_exploded/manage/login.jsp';");
            out.write("</script>");
        }else if ("loginout".equals(url)){
            HttpSession session=req.getSession();
            session.removeAttribute("user");
            //退出成功
            out.write("<script>");
            out.write("alert('退出成功');");
            out.write("location.href='/EmsDemo_war_exploded/login.jsp';");
            out.write("</script>");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
