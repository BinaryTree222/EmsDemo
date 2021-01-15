<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <link rel="stylesheet" href="css/verfy.css">
    <script src="js/jquery-1.12.4.js"></script>
    <script src="js/calendar.js"></script>
    <script src="js/verfy.js"></script>
    <script src="js/checks.js"></script>


</head>
<body><!-------------------reg-------------------------->

<div class="reg">
    <form  action="${pageContext.request.contextPath}/reg.user" method="post" onsubmit="return checkAll()">

           <h1 style="padding: 0px;margin: 0px;font-size: 30px;background-color: darkseagreen;text-align: center;line-height: 50px;color: fuchsia">用户注册</h1>

        <p  >
            <input type="text" id="userName" name="userName" value="" onblur="javascript:checkUserName()" placeholder="请输入用户名">
            <input type="hidden" id="unflag" value="1">
            <span id="errUserName"></span>
        </p>
        <p>
            <input type="text" id="name" name="name" value="" placeholder="请输入姓名">
            <span id="errName"></span>
        </p>
        <p>
            <input style="width: 15px;height: 15px" type="radio" name="sex" value="" checked >男
            <input style="width: 15px;height: 15px" type="radio" name="sex" value=""  >女
        </p>
        <p><input type="text" id="passWord" name="passWord" value="" placeholder="请输入密码">
            <span id="errPwd"></span></p>
        <p><input type="text" id="repassWord" name="repassWord" value="" placeholder="请确认密码">
            <span  id="errRePwd"></span>
        </p>
        <p><input  type="text" id="birthday" name="birthday" onclick="c.show(this)" placeholder="请输入日期">
            <span id="errBirthday"></span>
        </p>
        <p><input type="text" id="email" name="email" value="" placeholder="请输入邮箱">
            <span id="errEmail"></span>
        </p>
        <p><input type="text" id="mobile" name="mobile" value="" placeholder="请输入电话号码">
            <span id="errMobile"></span>
        </p>
        <p><input type="text" id="address" name="address" value="" placeholder="请输入地址">
            <span id="errAddress"></span>
        </p>
        <p >
<%--            <input class="code" type="text" name="" value="" placeholder="验证码"><img--%>
<%--                src="img/temp/code.jpg">--%>
    <input  type="text" id="vc" style="width: 100px;padding-left: 30px;height: 25px;margin-top: 5px;" value="1" placeholder="验证码" class="input-val ipt" />
    <canvas id="canvas" width="100" height="43"></canvas>
        </p>
        <p><input style="align-items: center" type="submit" id="submit" name="" value="注册"></p>
        <p class="txtL txt">完成此注册，即表明您同意了我们的<a href="#">
            <使用条款和隐私策略>
        </a></p>
        <p class="txt"><a href="${pageContext.request.contextPath}/login.jsp"><span></span>已有账号登录</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>-->
    </form>
</div>
</body>
</html>