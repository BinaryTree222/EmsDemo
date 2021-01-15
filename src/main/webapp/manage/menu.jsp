<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/9
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<c:if test="${empty superuser}" var="w">
    <%
        response.sendRedirect("/EmsDemo_war_exploded/manage/login.jsp");
    %>
</c:if>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8"/>
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manage/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manage/css/main.css"/>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.jsp" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="${pageContext.request.contextPath}/manage/index.jsp">首页</a></li>
                <li><a target="" href="${pageContext.request.contextPath}/index.jsp" >网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li>
                    <c:if test="${ empty superuser}" var="f">
                        <a href="#">管理员</a>
                    </c:if>
                    <c:if test="${!f}">
                        ${superuser.userId}
                    </c:if>
                </li>
                <li>
                    <a href="#">修改密码</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/excitback.user">退出</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
                    <ul class="sub-menu">
                        <li><a href="${pageContext.request.contextPath}/querypage.user"><i class="icon-font">&#xe008;</i>用户管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/query.cate"><i class="icon-font">&#xe005;</i>分类管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/querypage.pro"><i class="icon-font">&#xe006;</i>产品管理</a></li>
                        <li><a href="design.jsp"><i class="icon-font">&#xe004;</i>订单管理</a></li>
                        <li><a href="design.jsp"><i class="icon-font">&#xe012;</i>留言管理</a></li>
                        <li><a href="design.jsp"><i class="icon-font">&#xe052;</i>新闻管理</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe018;</i>系统管理</a>
                    <ul class="sub-menu">
                        <li><a href="system.jsp"><i class="icon-font">&#xe017;</i>系统设置</a></li>
                        <li><a href="system.jsp"><i class="icon-font">&#xe037;</i>清理缓存</a></li>
                        <li><a href="system.jsp"><i class="icon-font">&#xe046;</i>数据备份</a></li>
                        <li><a href="system.jsp"><i class="icon-font">&#xe045;</i>数据还原</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>


