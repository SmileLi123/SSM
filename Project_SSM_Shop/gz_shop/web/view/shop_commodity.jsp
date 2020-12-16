<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zoe
  Date: 2020/9/16
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商家商品主页</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link href="/css/commodity.css" rel="stylesheet" type="text/css" media="all">
    <script>
        function warning5(){
            var state=confirm("确认删除？")
            if(state)
                alert("删除成功！")
            else
                return false
        }
    </script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">网上购物系统</a>
        </div>

        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/Commodity/shopCommodity.form?sname=${sname}">店家商品</a></li>
                <li><a href="/Order/shopOrder.form?sname=${sname}">订单</a></li>
                <li><a href="/Shop/info.form?sname=${sname}">信息</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">${sessionScope.get("sname")}</a></li>
                <li><a href="/Shop/logout.form"><u>退出登录</u></a></li>
            </ul>
        </div>
    </div>
</nav>


<div class="container">
    <a href="/view/shop_add_commodity.jsp" class="navbar-right btn btn-info">添加</a>
    <div class="panel-heading">
        <h3>商品主页</h3>

    </div>


    <div class="panel panel-default">
        <table class="table" >
            <tr >
                <td width="100">商品名</td>
                <td width="80">价格</td>
                <td>描述</td>
                <td width="100">分类</td>
                <td width="80">修改 </td>
                <td width="80">删除</td>
                <td  width="80">评价</td>
            </tr>
            <c:forEach items="${lists}" varStatus="status">
                <c:set var="et" value="${status.current}"/>                       
                <tr>
                    <td>${et.cname}</td>
                    <td>${et.price}</td>
                    <td>${et.describtion}</td>
                    <td >${et.caname}</td>
                    <td><a class="btn btn-default" href="/Commodity/updateByShop.form?sname=${sname}&cid=${et.cid}" >修改</a> </td>
                    <td ><a class="btn btn-danger" href="/Commodity/deleteByShop.form?sname=${sname}&cid=${et.cid}"  onclick="return warning5()">删除</a> </td>
                    <td ><a class="btn btn-info" href="/Appraise/shopAppraise.form?sname=${sname}&cid=${et.cid}">查看</a> </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<script src="../js/jquery-3.3.1.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
</body>
</html>
