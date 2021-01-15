<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<html>
<head>
    <title></title>
</head>
<body>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>最家</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
    <c:if test="${empty listofcate}">
        <%
            response.sendRedirect("/EmsDemo_war_exploded/loadindex.rec");
        %>
    </c:if>
</head>
<body><!------------------------------head------------------------------>
<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="index.jsp">
            <%--            <img src="img/logo.png"/>--%>
        </a></h1>
            <div class="fr clearfix" id="top1">
                <p class="fl">
                    <c:if test="${empty user}" var="f">
                        <a href="${pageContext.request.contextPath}/login.jsp" id="login">登录</a><a href="${pageContext.request.contextPath}/reg.jsp" id="reg">注册</a>
                    </c:if>
                    <c:if test="${!f}">
                        ${user.userId}
                    </c:if>
                </p>
                <form action="#" method="get" class="fl"><input type="text" placeholder="热门搜索：干花花瓶"/><input
                        type="button"/></form>
                <div class="btn fl clearfix">
                    <a href="mygxin.jsp"><img src="img/grzx.png"/></a>
                    <a href="#" class="er1"><img src="img/ewm.png"/></a>
                    <a href="${pageContext.request.contextPath}/tocart.cart"><img src="img/gwc.png"/></a>
                    <p><a href="#"><img src="img/smewm.png"/></a></p>
                </div>
            </div>

        </div>
        <ul class="clearfix" id="bott">
            <li><a href="${pageContext.request.contextPath}/loadindex.rec">首页</a></li>
            <c:forEach var="p" items="${listofcate}">
                <li>
                    <c:if test="${p.cateParentId==0}" >
                        <a href="${pageContext.request.contextPath}/tocate.rec?id=${p.cateId}">${p.cateName}</a>
                    </c:if>

                    <div class="sList2">
                        <div class="clearfix">
                            <c:forEach var="c" items="${listofcate}">
                                <c:if test="${p.cateId==c.cateParentId}">
                                    <a href="${pageContext.request.contextPath}/tocate.rec?id=${c.cateId}">${c.cateName}</a>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </li>

            </c:forEach>
        </ul>
    </div>
</div>
</body>
</html>
