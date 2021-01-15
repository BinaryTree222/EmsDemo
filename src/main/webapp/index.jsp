<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>

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
<body>
<!------------------------------head------------------------------>
<jsp:include page="receptionhead.jsp"></jsp:include>
<!-------------------------banner--------------------------->
<div class="block_home_slider">
    <div id="home_slider" class="flexslider">
        <ul class="slides">
            <li>
                <div class="slide"><img src="img/banner2.jpg"/></div>
            </li>
            <li>
                <div class="slide"><img src="img/banner1.jpg"/></div>
            </li>
        </ul>
    </div>
</div><!------------------------------thImg------------------------------>
<div class="thImg">
    <div class="clearfix">

        <c:forEach var="l" items="${listindex}" begin="1" end="3">
            <a href="${pageContext.request.contextPath}/todetail.pro?id=${l.pId}"><img style="width: 355px;height: 300px" src="img/product/${l.pPfilename}"/><p></p></a>
        </c:forEach>
    </div>
</div><!------------------------------news------------------------------>
<div class="news">
    <div class="wrapper">
        <h2><img src="img/ih1.jpg"/></h2>
        <div class="top clearfix">
            <c:forEach var="l" items="${listindex}" begin="1" end="3">
            <a href="${pageContext.request.contextPath}/todetail.pro?id=${l.pId}"><img style="width: 355px;height: 300px" src="img/product/${l.pPfilename}"/><p></p></a>
            </c:forEach>
        </div>
        <div class="bott clearfix">
            <c:forEach var="l" items="${listindex}" begin="4" end="6">
                <a href="${pageContext.request.contextPath}/todetail.pro?id=${l.pId}"><img style="width: 355px;height: 300px" src="img/product/${l.pPfilename}"/><p></p></a>
            </c:forEach>
        </div>
        <h2><img src="img/ih2.jpg"/></h2>
        <div class="flower clearfix tran">

            <c:forEach var="l" items="${listindex}" begin="1" end="3">
                <a href="${pageContext.request.contextPath}/todetail.pro?id=${l.pId}" class="clearfix">
                <dl>
                    <dt><span class="abl"></span><img style="width: 355px;height: 300px" src="img/product/${l.pPfilename}"/><span class="abr"></span></dt>
                    <dd>${l.pName}</dd>
                    <dd><span>￥${l.pPrice}</span></dd>
                </dl>
                </a>
            </c:forEach>
        </div>

        <div class="flower clearfix tran">
            <c:forEach var="l" items="${listindex}" begin="4" end="6">
                <a href="${pageContext.request.contextPath}/todetail.pro?id=${l.pId}" class="clearfix">
                    <dl>
                        <dt><span class="abl"></span><img style="width: 355px;height: 300px" src="img/product/${l.pPfilename}"/><span class="abr"></span></dt>
                        <dd>${l.pName}</dd>
                        <dd><span>￥${l.pPrice}</span></dd>
                    </dl>
                </a>
            </c:forEach>
        </div>
    </div>
</div><!------------------------------ad------------------------------><a href="#" class="ad"><img
        src="img/ib1.jpg"/></a><!------------------------------people------------------------------>
<div class="people">
    <div class="wrapper">
        <h2><img src="img/ih3.jpg"/></h2>
        <div class="pList clearfix tran">
            <c:forEach var="l" items="${listindex}" begin="1" end="3">
                <a href="${pageContext.request.contextPath}/todetail.pro?id=${l.pId}" class="clearfix">
                    <dl>
                        <dt><span class="abl"></span><img style="width: 355px;height: 300px" src="img/product/${l.pPfilename}"/><span class="abr"></span></dt>
                        <dd>${l.pName}</dd>
                        <dd><span>￥${l.pPrice}</span></dd>
                    </dl>
                </a>
            </c:forEach>
        </div>
        <div class="pList clearfix tran">
            <c:forEach var="l" items="${listindex}" begin="4" end="6">
                <a href="${pageContext.request.contextPath}/todetail.pro?id=${l.pId}" class="clearfix">
                    <dl>
                        <dt><span class="abl"></span><img style="width: 355px;height: 300px" src="img/product/${l.pPfilename}"/><span class="abr"></span></dt>
                        <dd>${l.pName}</dd>
                        <dd><span>￥${l.pPrice}</span></dd>
                    </dl>
                </a>
            </c:forEach>
        </div>
        <div class="pList clearfix tran">
            <c:forEach var="l" items="${listindex}" begin="7" end="9">
                <a href="${pageContext.request.contextPath}/todetail.pro?id=${l.pId}" class="clearfix">
                    <dl>
                        <dt><span class="abl"></span><img style="width: 355px;height: 300px" src="img/product/${l.pPfilename}"/><span class="abr"></span></dt>
                        <dd>${l.pName}</dd>
                        <dd><span>￥${l.pPrice}</span></dd>
                    </dl>
                </a>
            </c:forEach>
        </div>
    </div>
</div><!--返回顶部-->
<div class="gotop"><a href="cart.jsp">
    <dl>
        <dt><img src="img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
    </dl>
</a><a href="#" class="dh">
    <dl>
        <dt><img src="img/gt2.png"/></dt>
        <dd>联系<br/>客服</dd>
    </dl>
</a><a href="mygxin.jsp">
    <dl>
        <dt><img src="img/gt3.png"/></dt>
        <dd>个人<br/>中心</dd>
    </dl>
</a><a href="#" class="toptop" style="display: none">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
    <p>400-800-8200</p></div><!-------------------login--------------------------><!--footer-->
<div class="footer">
    <div class="top">
        <div class="wrapper">
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot1.png"/></a><span class="fl">7天无理由退货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot2.png"/></a><span class="fl">15天免费换货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot3.png"/></a><span class="fl">满599包邮</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot4.png"/></a><span class="fl">手机特色服务</span>
            </div>
        </div>
    </div>
    <p class="dibu">最家家居&copy;2013-2017公司版权所有 京ICP备080100-44备0000111000号<br/>
        违法和不良信息举报电话：400-800-8200，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</p></div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">$(function () {
    $('#home_slider').flexslider({
        animation: 'slide',
        controlNav: true,
        directionNav: true,
        animationLoop: true,
        slideshow: true,
        slideshowSpeed: 2000,
        useCSS: false
    });
});</script>
</body>
</html>