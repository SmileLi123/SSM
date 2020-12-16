<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zoe
  Date: 2020/9/16
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户商品主页</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link href="/css/commodity.css" rel="stylesheet" type="text/css" media="all">
    <script src="../js/jquery-3.3.1.js"></script>
</head>
<body>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">网上购物系统</a>
        </div>
        <div >
            <ul class="nav navbar-nav">
                <li  class="active"><a href="/Commodity/userCommodity.form?uname=${uname}" data-toggle="dropdown">商品主页<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/Commodity/userCommodity.form?uname=${uname}">全部</a></li>
                                <li><a href="/Commodity/cloth.form?uname=${uname}">服装</a></li>
                                <li><a href="/Commodity/goods.form?uname=${uname}">百货</a></li>
                                <li><a href="/Commodity/shoes.form?uname=${uname}">鞋靴</a></li>
                                <li><a href="/Commodity/packet.form?uname=${uname}">箱包</a></li>
                                <li><a href="/Commodity/electric.form?uname=${uname}">家电</a></li>
                            </ul>
                </li>
                <li><a href="/Scart/queryByUname.form?uname=${uname}">购物车</a></li>
                <li ><a href="/Order/userOrder.form?uname=${uname}">订单</a></li>
                <li><a href="/Appraise/userAppraise.form?uname=${uname}">评价</a></li>
                <li><a href="/User/info.form?uname=${uname}" >信息</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><%=session.getAttribute("uname")%></a></li>
                <li><a href="/User/logout.form"><u>退出登录</u></a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <form class="navbar-form navbar-right" role="search" action="/Commodity/queryByCName.form">
        <div class="form-group">
            <input type="text" class="form-control" placeholder="请输入商品名" name="cname">
        </div>
        <input name="uname" value="${uname}" style="display: none">
        <button class="btn btn-default" type="submit">搜索</button>
    </form>

    <div class="panel-heading">
        <h3>商品主页</h3>
    </div>
    <div class="panel panel-default">
        <table class="table">
            <tr><td width="120">店铺名</td><td width="100">商品名字</td><td width="100">商品价格</td><td>商品描述</td><td width="80">功能</td><td width="80">购物车</td><td width="80">查看</td></tr>
            <c:forEach items="${list}" varStatus="status">
                <c:set var="et" value="${status.current}"/>                       
                <tr><td><a href="/Shop/shopInfo.form?uname=${uname}&sname=${et.sname}">${et.sname}</a></td><td>${et.cname}</td>
                 <td>${et.price}</td><td>${et.describtion}</td>
                    <td width="80"><a class="btn btn-info" href="/Order/addOrderfromCom.form?cid=${et.cid}&uname=${uname}">购买</a></td>
                    <td width="80"><a class="btn btn-danger" href="/Scart/addScart.form?cid=${et.cid}&uname=${uname}">添加</a></td>
                    <td width="80"><a class="btn btn-default" href="/Appraise/commodity_appraise.form?uname=${uname}&cid=${et.cid}">查看评论</a></td></tr>
             </c:forEach>
        </table>
    </div>
</div>
<script src="../js/jquery-3.3.1.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
<script type="text/javascript">

</script>
</body>
</html>
