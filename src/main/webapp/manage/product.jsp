<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<%@include file="menu.jsp"%>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">产品管理</span></div>
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
                        <a href="${pageContext.request.contextPath}/toadd.pro"><i class="icon-font"></i>新增产品</a>
<%--                        <a id="batchDel" href="javascript:void(0)"><i class="icon-font"></i>批量删除</a>--%>
<%--                        <a id="updateOrd" href="${pageContext.request.contextPath}/querypage.user"><i class="icon-font"></i>更新排序</a>--%>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%">
                                <input class="allChoose" name="id[]" type="checkbox" onclick="selectall(this)">
                            </th>

                            <th>产品id</th>
                            <th>产品名</th>
                            <th >产品价格</th >
                            <th>产品数量</th>
                            <th>一级分类</th>
                            <th>二级分类</th>
                            <th>图片名</th>
                            <th>操作</th>
                        </tr>

                        <c:forEach var="pro" items="${prolist}">
                        <tr>
                            <td class="tc"><input name="id[]" value="59" type="checkbox"></td>
                            <td>
                                ${pro.pId}
                            </td>
                            <td >
                                 ${pro.pName}
                            </td>
                            <td>
                                ${pro.pPrice}
                            </td>
                            <td>
                                 ${pro.pCount}
                            </td>
                            <td>
                                    ${pro.pCate1}
                            </td>
                            <td>
                                    ${pro.pCate2}
                            </td>
                            <td>
                                    ${pro.pPfilename}
                            </td>
                            <td>
                                <a class="link-update" href="${pageContext.request.contextPath}/findproductebyid.pro?id=${pro.pId}">修改</a>
                                <a class="link-del" href="javascript:Delete('你确定删除${pro.pName}?','${pageContext.request.contextPath}/delete.pro?id${pro.pId}')">删除</a>
                            </td>
                        </tr>
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
            <jsp:include page="pageinfo.jsp"></jsp:include>
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