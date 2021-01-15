<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<%@include file="menu.jsp"%>

    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="../index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="design.jsp">用户管理</a><span class="crumb-step">&gt;</span><span>新增用户</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="${pageContext.request.contextPath}/add.pro" method="post" id="myform" name="myform" enctype="multipart/form-data" onsubmit="return checkall()">
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <tr>
                            <th><i class="require-red">*</i>产品名：</th>
                            <td>
                                <input class="common-text required" id="pName" name="pName" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                                <th><i class="require-red">*</i>产品描述：</th>
                                <td>
                                    <input class="common-text required" id="pDes" name="pDes" size="50" value="" type="text">
                                </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>产品价格：</th>
                            <td>
                                <input class="common-text required" id="price" name="price" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>产品数量：</th>
                            <td>
                                <input class="common-text required" id="count" name="count" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>产品分类：</th>
                            <td>
                                <select class="common-text required" id="parentId" name="parentId">
                                    <c:forEach var="p" items="${allcate}">
                                        <c:if test="${p.cateParentId==0}">
                                        <option value="${p.cateId}-null">${p.cateName}</option>
                                        </c:if>
                                        <c:forEach var="c" items="${allcate}">
                                            <c:if test="${c.cateParentId==p.cateId}">
                                                <option value="${c.cateId}-${c.cateParentId}">&nbsp;&nbsp;&nbsp;-${c.cateName}</option>
                                            </c:if>
                                        </c:forEach>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <th><i class="require-red">*</i>产品图片文件：</th>
                            <td>
                                <input class="common-text required" id="picname" name="picname" size="50" value="上传" type="file">
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