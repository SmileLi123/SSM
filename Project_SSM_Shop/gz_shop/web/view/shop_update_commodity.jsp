<%--
  Created by IntelliJ IDEA.
  User: zoe
  Date: 2020/9/17
  Time: 8:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商家修改商品页面</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link href="/css/commodity.css" rel="stylesheet" type="text/css" media="all">
</head>
<body>
<%  String error2=(String)session.getAttribute("error2");
    if(error2==null||error2.equals(""))
        error2="";
%>
<div class="container">
    <div class="panel-heading">
        <h3>修改商品</h3>
        <label style="font-size: 18px;color: red;"><%=error2 %></label>
    </div>
    <%
        session.setAttribute("error2",null);
    %>
    <form method="post" action="/Commodity/updateCommodity.form">
        <div class="row">
            <input type="text" readonly="true" name="sname" value="${commodity.sname}" style="display: none;">
            <input type="text" readonly="true" name="cid" value="${commodity.cid}" style="display: none;">
            <div class="col-lg-6">
                <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px"> 名称</button>
                    </span>
                    <input type="text" class="form-control" placeholder="商品名" name="cname" value="${commodity.cname}" >
                </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
            <div class="col-lg-6">
                <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px"> 价格</button>
                    </span>
                    <input type="text" class="form-control" placeholder="商品价格" name="price" value="${commodity.price}">
                </div>
            </div>
        </div>
        <div class="row" style="margin-top: 15px">
            <div class="col-lg-6">
                <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px"> 分类</button>
                    </span>
                    <select name="caname">
                        <option value="null">--请选择类型--</option>
                        <option value="cloth" >服装</option>
                        <option value="goods" >百货</option>
                        <option value="shoes" >鞋靴</option>
                        <option value="packet" >箱包</option>
                        <option value="electric" >家电</option>
                    </select><br>
                </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
            <div class="col-lg-6">
                <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px"> 简介</button>
                    </span>
                    <input type="text" class="form-control" placeholder="商品描述" name="describtion" value="${commodity.describtion}">
                </div>
            </div>
        </div>

        <div class="btn-group btn-group-justified" id="btn" role="group" style="margin-top: 15px">
            <div class="btn-group" role="group">
                <a href="/Commodity/shopCommodity.form?sname=${commodity.sname}" class="btn btn-default">返回</a>
            </div>
            <div class="btn-group" role="group">
                <input type="submit" class="btn btn-info" value="提交">
            </div>
        </div>

    </form>
</div>

</body>
</html>
