<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 15721
  Date: 2020/10/1
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户订单页面</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <link href="/css/commodity.css" rel="stylesheet" type="text/css" media="all">
  <script src="../js/jquery-3.3.1.js"></script>
  <script >
      function warning3(){
        var state=confirm("确认取消？")
        if(state)
          alert("取消成功！")
        else
          return false
       }
    function warning2(){
      var state=confirm("确认收货？")
      if(state)
        alert("确认成功！")
      else
        return false
    }
  </script>
</head>
<body>
<%  String error1=(String)session.getAttribute("error1");
  if(error1==null||error1.equals("")){
    error1="";
  }else{
%>
<script type="text/javascript">
  alert("<%=error1%>")
</script>
<%
    session.setAttribute("error1",null);
  }
%>
<nav class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <a href="#" class="navbar-brand">网上购物系统</a>
    </div>
    <div class="collapse navbar-collapse">
      <ul class="nav navbar-nav" >
        <li ><a href="/Commodity/userCommodity.form?uname=${uname}">商品主页<b class="caret"></b></a></li>
        <li><a href="/Scart/queryByUname.form?uname=${uname}">购物车</a></li>
        <li class="active"><a href="/Order/userOrder.form?uname=${uname}">订单</a></li>
        <li><a href="/Appraise/userAppraise.form?uname=${uname}">评价</a></li>
        <li ><a href="/User/info.form?uname=${uname}">信息</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">${uname}</a></li>
        <li><a href="/User/logout.form"><u>退出登录</u></a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container">
  <div class="panel-heading">
    <h4>待发货</h4>
  </div>
  <div class="panel panel-default">
    <table class="table">
      <tr>
        <td >店铺名</td>
        <td >商品名</td>
        <td width="80">数量</td>
        <td width="80">总价</td>
        <td width="120">订单状态</td>
        <td width="80">信息</td>
        <td width="80">取消订单</td>
      </tr>
      <c:forEach items="${list}" varStatus="status">
        <c:set var="et" value="${status.current}"/>                       

        <tr>
          <input type="text" id="oid"  name="oid" value="${et.oid}" style="display: none">
          <td>${et.sname}</td>
          <td><a href="/Commodity/CommodityInfo.form?uname=${uname}&oid=${et.oid}">${et.cname}</a></td>
          <td>${et.num}</td>
          <td>${et.tprice}</td>
          <td>${et.state}</td>
          <td>
            <a class="btn btn-default"  href="/Order/queryByOid.form?oid=${et.oid}&uname=${uname}" >查看</a>
          </td>
          <td>
                <a class="btn btn-danger" href="/Order/deleteOrder.form?oid=${et.oid}&uname=${uname}" id="delete" onclick="return warning3()">取消</a>
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
      <table class="table">
        <tr>
          <td >店铺名</td>
          <td >商品名</td>
          <td width="80">数量</td>
          <td width="80">总价</td>
          <td width="120">订单状态</td>
          <td width="80">信息</td>
          <td width="80">确认收货</td>
        </tr>
        <c:forEach items="${lista}" varStatus="status">
          <c:set var="et" value="${status.current}"/>                       

          <tr>
            <input type="text" id="oid1"  name="oid" value="${et.oid}" style="display: none">
            <td>${et.sname}</td>
            <td><a href="/Commodity/CommodityInfo.form?uname=${uname}&oid=${et.oid}">${et.cname}</a></td>
            <td>${et.num}</td>
            <td>${et.tprice}</td>
            <td>${et.state}</td>
            <td>
              <a class="btn btn-default"  href="/Order/queryByOid.form?oid=${et.oid}&uname=${uname}" >查看</a>
            </td>
            <td>
              <a class="btn btn-info" href="/Order/updateOrderByUser.form?oid=${et.oid}&uname=${uname}" id="define" onclick="return warning2()">确认</a>
            </td>
          </tr>
        </c:forEach>
      </table>
    </div>
</div>
<div class="container">
  <div class="panel-heading">
    <h4>已收货</h4>
  </div>
  <div class="panel panel-default">
    <table class="table">
      <tr>
        <td >店铺名</td>
        <td >商品名</td>
        <td width="80">数量</td>
        <td width="80">总价</td>
        <td width="120">订单状态</td>
        <td width="80">信息</td>
      </tr>
      <c:forEach items="${listb}" varStatus="status">
        <c:set var="et" value="${status.current}"/>                       

        <tr>
          <input type="text" id="oid2"  name="oid" value="${et.oid}" style="display: none">
          <td>${et.sname}</td>
          <td><a href="/Commodity/CommodityInfo.form?uname=${uname}&oid=${et.oid}">${et.cname}</a></td>
          <td>${et.num}</td>
          <td>${et.tprice}</td>
          <td>${et.state}</td>
          <td>
            <a class="btn btn-default"  href="/Order/queryByOid.form?oid=${et.oid}&uname=${uname}" >查看</a>
          </td>

        </tr>
      </c:forEach>
    </table>
  </div>
</div>
<div class="container">
  <div class="panel-heading">
    <h4>已评价</h4>
  </div>
  <div class="panel panel-default">
    <table class="table">
      <tr>
        <td >店铺名</td>
        <td >商品名</td>
        <td width="80">数量</td>
        <td width="80">总价</td>
        <td width="120">订单状态</td>
        <td width="80">信息</td>
      </tr>
      <c:forEach items="${listc}" varStatus="status">
        <c:set var="et" value="${status.current}"/>                       

        <tr>
          <input type="text" id="oid3"  name="oid" value="${et.oid}" style="display: none">
          <td>${et.sname}</td>
          <td><a href="/Commodity/CommodityInfo.form?uname=${uname}&oid=${et.oid}">${et.cname}</a></td>
          <td>${et.num}</td>
          <td>${et.tprice}</td>
          <td>${et.state}</td>
          <td>
            <a class="btn btn-default"  href="/Order/queryByOid.form?oid=${et.oid}&uname=${uname}" >查看</a>
          </td>

        </tr>
      </c:forEach>
    </table>
  </div>
</div>
</body>
</html>
