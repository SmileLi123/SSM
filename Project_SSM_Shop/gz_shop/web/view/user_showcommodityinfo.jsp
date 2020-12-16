<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>商品信息页面</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <link href="/css/commodity.css" rel="stylesheet" type="text/css" media="all" />
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
<div class="container">
  <div class="panel-heading"  >
    <h3><c style="float: left;width: 95%">查看商品信息</c></h3><a  href="/Order/userOrder.form?uname=${uname}"class=" btn btn-info">返回</a>
  </div>
  <form method="post" action="/Order/addOrderfromCom.form">
    <input type="text" readonly="true"  name="uname" value="${uname}" style="display: none">
    <input type="text" readonly="true"  name="cid" value="${commodity.cid}" style="display: none">
    <div class="row">
      <div class="col-lg-6">
        <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px"> 商品名</button>
                    </span>
          <input type="text" class="form-control"  readonly="true"  name="cname" value="${commodity.cname}">
        </div>
      </div>
      <div class="col-lg-6">
        <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px"> 所属分类</button>
                    </span>
          <input type="text" class="form-control" readonly="true"  name="caname" value="${commodity.caname}">
        </div>
      </div>
    </div>
    <div class="row" style="margin-top: 15px">
      <div class="col-lg-6">
        <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px"> 售价</button>
                    </span>
          <input type="text" class="form-control" readonly="true"  name="price" value="${commodity.price}">
        </div>
      </div>
      <div class="col-lg-6">
        <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px"> 商品描述</button>
                    </span>
          <input type="text" class="form-control" readonly="true"  name="describtion" value="${commodity.describtion}">
        </div>
      </div>
    </div>
    <div class="btn-group btn-group-justified" role="group" style="padding-top: 120px ;padding:50px">
      <div class="btn-group" role="group">
        <input type="submit" class="btn btn-info" value="再次购买" width="50">
      </div>
      <div class="btn-group" role="group">
        <a href="/Scart/addScart.form?cid=${commodity.cid}&uname=${uname}" class="btn btn-danger" > 添加到购物车</a>
      </div>
    </div>

  </form>
</div>
</body>
</html>