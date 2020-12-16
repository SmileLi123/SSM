<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fate
  Date: 2020/6/26
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户评价页面</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link href="/css/commodity.css" rel="stylesheet" type="text/css" media="all">
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">网上购物系统</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/Commodity/userCommodity.form?uname=${uname}">商品主页<b class="caret"></b></a></li>
                <li><a href="/Scart/queryByUname.form?uname=${uname}">购物车</a></li>
                <li ><a href="/Order/userOrder.form?uname=${uname}">订单</a></li>
                <li class="active"><a href="/Appraise/userAppraise.form?uname=${uname}">评价</a></li>
                <li><a href="/User/info.form?uname=${uname}">信息</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><%=session.getAttribute("uname")%></a></li>
                <li><a href="/User/logout.form"><u>退出登录</u></a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="panel-heading">
        <h4>待评价</h4>
    </div>
    <div class="panel panel-default">
        <table class="table">
            <tr>
                <td>店铺名</td>
                <td>商品名</td>
                <td>功能</td>
            </tr>
            <c:forEach items="${list}" varStatus="status">
                <c:set var="et" value="${status.current}"/>                       
                <tr>
                    <td>${et.sname}</td>
                    <td>${et.cname}</td>
                    <td><a class="btn btn-default add"
                           href="#">评价</a>
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
            <tr >
                <td>店铺名</td>
                <td>商品名</td>
                <td>评价等级</td>
                <td>评价内容</td>
            </tr>
            <c:forEach items="${lista}" varStatus="status">
                <c:set var="et" value="${status.current}"/>                       
                <tr>
                    <td>${et.sname}</td>
                    <td>${et.cname}</td>
                    <td>${et.grade}</td>
                    <td>${et.info}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>


<div class="modal fade" id="add_keyword" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel1">添加评价</h4>
            </div>
            <form method="get" action="/Appraise/addAppraise.form">
            <div class="modal-body">
                <div style="text-align: center ;padding: 10px">
                    <input checked type="radio" name="grade" value="好评" >好评&nbsp&nbsp&nbsp
                    <input  type="radio" name="grade" value="中评">中评&nbsp&nbsp&nbsp
                    <input  type="radio" name="grade" value="差评">差评
                </div>
                <input type="text" id="word" class="form-control" placeholder="添加评价" name="info">
            </div>
            <div class="modal-footer">
                <c:forEach items="${list}" varStatus="status">
                    <c:set var="ed" value="${status.current}"/>                       
                    <tr>
                        <input name="uname" value="${uname}" style="display: none">
                        <input name="sname" value="${ed.sname}" style="display: none">
                        <input name="cname" value="${ed.cname}" style="display: none">
                        <input name= "oid"  id="oid" value="${ed.oid}" style="display: none">
                    </tr>
                </c:forEach>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="submit" class="btn btn-primary" id="btn_add_keyword" >添加</button>
            </div>
            </form>
        </div>
    </div>
</div>




<script src="../js/jquery-3.3.1.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
<script type="text/javascript">
    $(document).on('click', '.add', function () {

        $("#add_keyword").modal();
    });

    $(document).on('click', '#btn_add_keyword', function (){
                $("#add_keyword").modal("hide");
                alert("添加成功");
    });
</script>


</body>
</html>

