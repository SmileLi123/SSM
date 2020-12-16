
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息页面</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link href="/css/commodity.css" rel="stylesheet" type="text/css" media="all">
    <script>
        function warning(){
            var state=confirm("确认修改？")
                if(state) {
                    var uname = $("#uname").val();
                    var password = $("#password").val();
                    var phone = $("#phone").val();
                    var address = $("#address").val();
                    $.ajax({
                        url: "/User/updatecheck.form",
                        type: "POST",
                        dataType: "text",
                        data: {uname: uname, password: password, phone: phone, address: address},
                        success: function (data) {
                            //alert(uname);
                            if (data == "0") {
                                alert("密码不能为空")
                            }
                            if (data == "1")
                                alert("手机号不能为空")
                            if (data == "2")
                                alert("地址不能为空")
                            if (data == "3")
                                alert("修改成功")
                        },
                        error: function () {
                            alert("失败")
                        }
                    })
                }
            else
                return false
        }
    </script>

</head>
<body >
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">网上购物系统</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav" >
                <li ><a href="/Commodity/userCommodity.form?uname=${uname}">商品主页<b class="caret"></b></a></li>
                <li><a href="/Scart/queryByUname.form?uname=${uname}">购物车</a></li>
                <li ><a href="/Order/userOrder.form?uname=${uname}">订单</a></li>
                <li><a href="/Appraise/userAppraise.form?uname=${uname}">评价</a></li>
                <li class="active"><a href="/User/info.form?uname=${uname}">信息</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">${user.uname}</a></li>
                <li><a href="/User/logout.form"><u>退出登录</u></a></li>

            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <form method="post" action="/User/update.form">
        <div class="row">
            <div class="col-lg-6">
                <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px"> 用户名</button>
                    </span>
                    <input type="text" class="form-control" readonly="true"  name="uname" value="${user.uname}" id="uname">
                </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
            <div class="col-lg-6">
                <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px">密码</button>
                    </span>
                    <input type="text" class="form-control" placeholder="密码" name="password"value="${user.password}" id="password">
                </div>
            </div>
        </div>
        <div class="row" style="margin-top: 15px">
            <div class="col-lg-6">
                <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px">手机号</button>
                    </span>
                    <input type="text" class="form-control" placeholder="手机号" name="phone"value="${user.phone}" id="phone">
                </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
            <div class="col-lg-6">
                <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px">邮箱</button>
                    </span>
                    <input type="text" class="form-control" placeholder="邮箱" name="email" value="${user.email}">
                </div>
            </div>
        </div>
        <div class="row" style="margin-top: 15px">
            <div class="col-lg-6">
                <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px">地址</button>
                    </span>
                    <input type="text" class="form-control" placeholder="地址" name="address"value="${user.address}" id="address">
                </div>
            </div>
        </div>
        <div class="btn-group btn-group-justified" role="group" style="padding-top: 120px ;padding:50px">
            <div class="btn-group" role="group">
                <input type="submit" class="btn btn-info" value="修改信息"  onclick="return warning()">
            </div>
            <div class="btn-group" role="group">
                <a href="/User/delete.form?uname=${uname}" class="btn btn-danger"  onclick="return confirm('确认注销此用户？')"> 注销用户</a>
            </div>
        </div>

    </form>
</div>

<script src="../js/jquery-3.3.1.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
</body>
</html>