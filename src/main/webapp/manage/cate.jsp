<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<%@include file="menu.jsp"%>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">作品管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="${pageContext.request.contextPath}/search.user" method="post">
                    <table class="search-tab">
                        <tr>
<%--                            <th width="120">选择分类:</th>--%>
<%--                            <td>--%>
<%--                                <select name="search-sort" id="22">--%>
<%--                                    <option value="">全部</option>--%>
<%--                                    <option value="19">精品界面</option><option value="20">推荐界面</option>--%>
<%--                                </select>--%>
<%--                            </td>--%>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="${pageContext.request.contextPath}/manage/cateadd.jsp"><i class="icon-font"></i>新增分类</a>
<%--                        <a id="batchDel" href="javascript:void(0)"><i class="icon-font"></i>批量删除</a>--%>
                        <a id="updateOrd" href="${pageContext.request.contextPath}/query.cate"><i class="icon-font"></i>更新排序</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%">
                                <input class="allChoose" name="id[]" type="checkbox" onclick="selectall(this)">
                            </th>

                            <th>分类id</th>
                            <th>分类名</th>
                            <th >父分类id</th >
                            <th>操作</th>
                        </tr>

                        <c:forEach var="cate" items="${catelist}">
                            <c:if test="${cate.cateParentId==0}">
                        <tr>
                            <td class="tc"><input name="id[]" value="59" type="checkbox"></td>
                            <td>
                                ${cate.cateId}
                            </td>
                            <td >
                                 ✡${cate.cateName}
                            </td>
                            <td>
                                 ${cate.cateParentId}
                            </td>
                            <td>
                                <a class="link-update" href="${pageContext.request.contextPath}/findcatebyid.cate?id=${cate.cateId}">修改</a>
                                <a class="link-del" href="javascript:Delete('你确定删除${cate.cateName}?','${pageContext.request.contextPath}/delete.cate?id=${cate.cateId}')">删除</a>
                            </td>
                        </tr>
                            </c:if>
                            <c:forEach var="c" items="${catelist}">
                                <c:if test="${c.cateParentId==cate.cateId}">
                                    <tr>
                                        <td class="tc"><input name="id[]" value="59" type="checkbox"></td>
                                        <td>
                                                ${c.cateId}
                                        </td>
                                        <td >&nbsp;
                                            &nbsp;&nbsp;➡${c.cateName}
                                        </td>
                                        <td>
                                                ${c.cateParentId}
                                        </td>
                                        <td>
                                            <a class="link-update" href="${pageContext.request.contextPath}/findcatebyid.cate?id=${c.cateId}">修改</a>
                                            <a class="link-del" href="javascript:Delete('你确定删除${c.cateName}分类吗?','${pageContext.request.contextPath}/delete.cate?id=${c.cateId}')">删除</a>
                                        </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </table>
                    <script>
                       function Delete(msg,url){
                           if (confirm(msg)){

                               window.location=url;
                           }

                        }
                        function selectall(o) {
                           var a=document.getElementsByName("id[]");
                           for (var i=0;i<a.length;i++){
                               a[i].checked=o.checked;

                            }

                        }

                    </script>

                    <div class="list-page" >
<%--                        页码--%>

<%--                        页码end--%>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>