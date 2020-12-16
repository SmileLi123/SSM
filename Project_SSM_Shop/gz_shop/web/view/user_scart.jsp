<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户订单页面</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link href="/css/commodity.css" rel="stylesheet" type="text/css" media="all">
    <script src="../js/jquery-3.3.1.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <script >
        function warning5() {
        var state=confirm("确认删除？")
            if(state)
            alert("删除成功！")
            else
            return false
        }
      //function jian() {
          $(document).on('click', '#jian', function () {
          //console.log(e)
             var num = $(this).parent().children("#num").val()
              if (!isNaN(num)) {
              num = parseInt(num);
              if (num == 0) {
                  return
              } else if (num > 0) {
                  num = num - 1;
                  if (num == 0)
                      $("#btn").attr("disabled", true)
                  $(this).parent().children("#num").val(num)
              }
          } else {
                  $(this).parent().children("#num").val(0)
          }
          var num =  $(this).parent().children("#num").val()
              var gid = $(this).parent().children("#gid").val()
              $.ajax({
              url: "/Scart/add.form",
              type: "POST",
              dataType: "text",
              data: {gid: gid, num: num},
              success: function (data) {

              },
              error: function () {
                  alert("失败")
              },
          })
           })
           $(document).on('click', '#jia', function (){
          //console.log(e)
          var num = $(this).parent().children("#num").val()
          if (!isNaN(num)) {
              num = parseInt(num)
              num = num + 1
              $(this).parent().children("#num").val(num)
              $("#btn").attr("disabled", false)
          } else {
              $(this).parent().children("#num").val(0)
          }
          var num = $(this).parent().children("#num").val()
               var gid = $(this).parent().children("#gid").val()
               $.ajax({
              url: "/Scart/add.form",
              type: "POST",
              dataType: "text",
              data: {gid: gid, num: num},
              success: function (data) {
                 //alert(num)
              },
              error: function () {
                  alert("失败")
              },
          })
          })

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
                <li><a href="/Commodity/userCommodity.form?uname=${uname}">商品主页<b class="caret"></b></a></li>
                <li class="active"><a href="/Scart/queryByUname.form?uname=${uname}">购物车</a></li>
                <li ><a href="/Order/userOrder.form?uname=${uname}">订单</a></li>
                <li><a href="/Appraise/userAppraise.form?uname=${uname}">评价</a></li>
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
        <h3>购物车主页</h3>
    </div>
    <div class="panel panel-default">
        <table class="table">
            <tr>
            <td width="120">店铺名</td>
            <td width="120">商品名</td>
            <td width="80">单价</td>
            <td width="100">数量</td>
            <td width="100">操作</td>
            <td width="100">操作</td>
            </tr>
            <c:forEach items="${listofscart}" varStatus="status">
                <c:set var="et" value="${status.current}"/>                       
                <tr>
                    <td>${et.sname}</td>
                    <td>${et.cname}</td>
                    <td>${et.price}</td>
                    <td>
                        <div class="btn-group" role="group">
                            <input name="gid" value="${et.gid}" style="display: none" id="gid">
                            <button type="button" class="btn btn-default" id="jian" >-</button>
                            <input style="width: 120px;" type="text"  class="btn btn-default" id="num" value="${et.num}">
                            <button type="button" class="btn btn-default" id="jia" >+</button>
                        </div>
                    </td>
                    <td>
                        <a class="btn btn-info"  href="/Order/addOrderfromScart.form?cid=${et.cid}&uname=${uname}&gid=${et.gid}">购买</a>
                    </td>
                    <td>
                        <a class="btn btn-danger" href="/Scart/deleteScart.form?gid=${et.gid}&uname=${uname}" onclick="return warning5()">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>


</body>
</html>
