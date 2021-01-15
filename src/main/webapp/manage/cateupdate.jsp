<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<%@include file="menu.jsp"%>

    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="../index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="design.jsp">分类管理</a><span class="crumb-step">&gt;</span><span>修改分类</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="${pageContext.request.contextPath}/update.cate" method="post" id="myform" name="myform" onsubmit="return checkall()">
                    <table class="insert-tab" width="100%">
                        <tbody>

                            <tr>
                                <th><i class="require-red">*</i>分类名称：</th>
                                <td>
                                    <input type="hidden" value="${cate1.cateId}" name="id">

                                    <input class="common-text required" id="cateName" name="cateName" size="50" value="${cate1.cateName}" type="text">
                                </td>
                            </tr>
                        <tr>
                            <th><i class="require-red">*</i>父级分类：</th>
                            <td>
                                <select class="common-text required" id="parentId" name="parentId">
                                    <option value="0">父分类</option>
                                    <c:forEach var="cate" items="${catelist}">
                                        <c:if test="${cate.cateParentId==0}">、
                                            <c:if test="${cate1.cateId==cate.cateId}" var="v">
                                                <option value="${cate1.cateId}" selected="selected">${cate1.cateName}</option>
                                            </c:if>
                                            <c:if test="${!v}">
                                                <option value="${cate.cateId}">${cate.cateName}</option>
                                            </c:if>
                                        </c:if>
                                    </c:forEach>
                                </select>
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