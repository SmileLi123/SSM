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
    <title>商家信息页面</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link href="/css/commodity.css" rel="stylesheet" type="text/css" media="all">
    <script src="../js/jquery-3.3.1.js"></script>
    <script>
        function warning1(){
            var state=confirm("确认修改？")
            if(state) {
                var sname = $("#sname").val();
                var password = $("#password").val();
                var sphone = $("#sphone").val();
                $.ajax({
                    url: "/Shop/updatecheck.form",
                    type: "POST",
                    dataType: "text",
                    data: {sname: sname, password: password, sphone: sphone},
                    success: function (data) {
                        //alert(uname);
                        if (data == "0") {
                            alert("密码不能为空")
                        }
                        if (data == "1")
                            alert("手机号不能为空")
                        if (data == "2")
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
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">网上购物系统</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/Commodity/shopCommodity.form?sname=${sname}">店家商品</a></li>
                <li><a href="/Order/shopOrder.form?sname=${sname}">订单</a></li>
                <li class="active"><a href="/Shop/info.form?sname=${sname}">信息</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">${sname}</a></li>
                <li><a href="/Shop/logout.form"><u>退出登录</u></a></li>
            </ul>
        </div>
    </div>
</nav>


<div class="container">
    <form method="post" action="/Shop/update.form">
        <div class="row">
            <div class="col-lg-6">
                <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px">店铺名</button>
                    </span>
                    <input type="text"  class="form-control" readonly="true"  name="sname" value="${shop.sname}" id="sname">
                </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
            <div class="col-lg-6">
                <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px">密码</button>
                    </span>
                    <input type="text" class="form-control" placeholder="密码" name="password" value="${shop.password}" id="password">
                </div>
            </div>
        </div>
        <div class="row" style="margin-top: 15px">
            <div class="col-lg-6">
                <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px">联系方式</button>
                    </span>
                    <input type="text" class="form-control" placeholder="联系方式" name="sphone" value="${shop.sphone}" id="sphone">
                </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
            <div class="col-lg-6">
                <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px">店铺简介</button>
                    </span>
                    <input type="text" class="form-control" placeholder="店铺简介" name="describtion" value="${shop.describtion}">
                </div>
            </div>
        </div>

        <div class="btn-group btn-group-justified" role="group" style="padding-top: 80px ">
            <div class="btn-group" role="group" >
                <input type="submit" class="btn btn-info" value="修改信息" onclick=" return warning1()">
            </div>
            <div class="btn-group" role="group" >
                <a href="/Shop/delete.form?sname=${sname}" class="btn btn-danger"  onclick="return confirm('确认注销此店铺？')">注销店铺</a>
            </div>
        </div>
    </form>
</div>

</body>
</html>
