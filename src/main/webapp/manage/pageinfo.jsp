<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/1
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table >
    <tr>
        <td>
            <c:if test="${pageinfo.curPageNo>1}" var="fg">
                <a href="${pageContext.request.contextPath}/${url}?curPageNo=1">首页</a>
                <a href="${pageContext.request.contextPath}/${url}?curPageNo=${pageinfo.curPageNo-1}">上一页</a>
            </c:if>
            <c:if test="${!fg}">
                <a href="#">首页</a>
                <a href="#">上一页</a>
            </c:if>
        </td>
        <td>
            <c:forEach var="i" begin="0" end="4">
                <c:if test="${(pageinfo.curPageNo+i)>=1 && (pageinfo.curPageNo+i)<=pageinfo.totalPageCount}">
                    <a href="${pageContext.request.contextPath}/${url}?curPageNo=${pageinfo.curPageNo+i}">${pageinfo.curPageNo+i}</a>
                </c:if>
            </c:forEach>
        </td>
        <td>

            <c:if test="${pageinfo.curPageNo<pageinfo.totalPageCount}" var="fgg">
                <a href="${pageContext.request.contextPath}/${url}?curPageNo=${pageinfo.curPageNo+1}">下一页</a>
                <a href="${pageContext.request.contextPath}/${url}?curPageNo=${pageinfo.totalPageCount}">末页</a>
            </c:if>
            <c:if test="${!fgg}">
                <a href="#">下一页</a>
                <a href="#">末页</a>
            </c:if>

        </td>
        <td>
            第${pageinfo.curPageNo}页 到<input type="number" value="${pageinfo.curPageNo}" style="width: 10%"   onchange="a(this.value);">
            共${pageinfo.totalPageCount}页  共${pageinfo.totalCount}条数据
        </td>
    </tr>
    <script>
        function a(t) {
            if (t>=1 && t<= ${pageinfo.totalPageCount}){
                window.location.href="${pageContext.request.contextPath}/${url}?curPageNo="+t;
            }
        }
    </script>
</table>
</body>
</html>
