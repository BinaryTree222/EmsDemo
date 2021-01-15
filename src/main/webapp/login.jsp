<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <link rel="stylesheet" href="css/verfy.css">
    <script src="js/jquery-1.12.4.js"></script>
    <script src="js/verfy.js"></script>
    <script src="js/checks.js"></script>
</head>
<body><!-------------------login-------------------------->
<div class="login">
    <form action="${pageContext.request.contextPath}/login.user" method="post" onsubmit="return loginCheck()">
        <h1><a href="index.jsp"><img src="img/temp/logo.png"></a></h1>
        <p></p>
        <div class="msg-warn hide"><b></b>公共场所不建议自动登录，以防账号丢失</div>
        <p>
            <input type="text" id="uN" name="userName" value="" placeholder="用户名/邮箱/手机号">
            <spqn id="errU"></spqn>
        </p>
        <p>
            <input type="text" id="pW" name="pWd" value="" placeholder="密码">
            <span id="errP"></span>
        </p>
        <p>
            <input  type="text" id="vc" style="width: 100px;padding-left: 30px;height: 25px;margin-top: 5px;" value="" placeholder="验证码" class="input-val ipt" />
            <canvas id="canvas" width="100" height="43"></canvas>
        </p>
        <p><input type="submit" name="" value="登  录"></p>
        <p class="txt"><a class="" href="reg.jsp">免费注册</a><a href="forget.jsp">忘记密码？</a></p></form>
</div>
</body>
</html>