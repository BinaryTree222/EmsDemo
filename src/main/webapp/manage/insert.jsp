<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<%@include file="menu.jsp"%>

    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="design.jsp">用户管理</a><span class="crumb-step">&gt;</span><span>新增用户</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="${pageContext.request.contextPath}/add.user" method="post" id="myform" name="myform" onsubmit="return checkall()">
                    <table class="insert-tab" width="100%">
                        <tbody>

                            <tr>
                                <th><i class="require-red">*</i>用户名：</th>
                                <td>
                                    <input class="common-text required" id="userName" name="userName" size="50" value="" type="text">
                                </td>
                            </tr>
                        <tr>
                            <th><i class="require-red">*</i>用户姓名：</th>
                            <td>
                                <input class="common-text required" id="name" name="name" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>登录密码：</th>
                            <td>
                                <input class="common-text required" id="password" name="passWord" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>确认密码：</th>
                            <td>
                                <input class="common-text required" id="repassword" name="repassWord" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>性别：</th>
                            <td>
                                <input type="radio" name="sex" value="1" checked>男
                                <input type="radio" name="sex" value="2" >女
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>出生日期：</th>
                            <td>
                                <input class="Wdate" type="text" name="birthday">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>手机号码：</th>
                            <td>
                                <input class="Wdate" type="text" name="mobile" >
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>电子邮箱：</th>
                            <td>
                                <input class="Wdate" type="text" name="email" >
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>地址：</th>
                            <td>
                                <input class="common-text required" size="50" type="text" name="address" >
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <input type="submit" value="提交" >

                                <input type="reset" value="重置" >
                            </td>
                        </tr>

                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>