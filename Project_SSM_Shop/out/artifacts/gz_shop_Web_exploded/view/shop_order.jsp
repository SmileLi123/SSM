<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zoe
  Date: 2020/9/16
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商家订单页面</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="../js/jquery-3.3.1.js"></script>
    <script >
        function warning6(){
            var state=confirm("确认发货？")
            if(state)
                alert("发货成功！")
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
                <li><a href="/Commodity/shopCommodity.form?sname=${sname}">店家商品</a></li>
                <li class="active"><a href="/Order/shopOrder.form?sname=${sname}">订单</a></li>
                <li><a href="/Shop/info.form?sname=${sname}">信息</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">${sname}</a></li>
                <li><a href="/Shop/logout.form"><u>退出登录</u></a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="panel-heading">
        <h4>待发货</h4>
    </div>
    <div class="panel panel-default">
        <table class="table" style="text-align: center">
            <tr>
                <td>商品名</td>
                <td>收货人</td>
                <td>联系电话</td>
                <td>收货地址</td>
                <td>数量</td>
                <td>发货</td>
            </tr>
            <c:forEach items="${daifahuo}" varStatus="status">
                <c:set var="et" value="${status.current}"/>                       
                <tr>
                    <td>${et.cname}</td>
                    <td>${et.hname}</td>
                    <td>${et.hphone}</td>
                    <td>${et.haddress}</td>
                    <td>${et.num}</td>
                    <td><a class="btn btn-default"
                           href="/Order/updateOrderByShop.form?sname=${sname}&oid=${et.oid}" id="send" onclick="return warning6()">发货</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<div class="container">
    <div class="panel-heading">
        <h4>已发货</h4>
    </div>
    <div class="panel panel-default">
        <table class="table" style="text-align: center">
            <tr>
                <td>商品名</td>
                <td>收货人</td>
                <td>联系电话</td>
                <td>收货地址</td>
                <td>数量</td>
                <td>订单状态</td>
            </tr>
            <c:forEach items="${list}" varStatus="status">
                <c:set var="et" value="${status.current}"/>                       
                <tr>
                    <td>${et.cname}</td>
                    <td>${et.hname}</td>
                    <td>${et.hphone}</td>
                    <td>${et.haddress}</td>
                    <td>${et.num}</td>
                    <td>${et.state}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
</body>
</html>
