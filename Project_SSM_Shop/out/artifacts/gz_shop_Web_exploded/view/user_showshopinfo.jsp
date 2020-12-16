<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>店铺信息页面</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <link href="/css/commodity.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>

<div class="container">
  <div class="panel-heading"  >
    <h3><c style="float: left;width: 95%">查看店铺信息</c></h3><a  href="/Commodity/userCommodity.form?uname=${uname}" class=" btn btn-info">返回</a>
  </div>
  <form >
    <input type="text" readonly="true"  name="uname" value="${uname}" style="display: none">
    <div class="row">
      <div class="col-lg-6">
        <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px"> 店铺名</button>
                    </span>
          <input type="text" class="form-control"  readonly="true"  name="sname" value="${shop.sname}">
        </div>
      </div>
      <div class="col-lg-6">
        <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px"> 联系方式</button>
                    </span>
          <input type="text" class="form-control" readonly="true"  name="sphone" value="${shop.sphone}">
        </div>
      </div>
    </div>
    <div class="row" style="margin-top: 15px">
      <div class="col-lg-6">
        <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px"> 店铺描述</button>
                    </span>
          <input type="text" class="form-control" readonly="true"  name="describtion" value="${shop.describtion}">
        </div><!-- /input-group -->
      </div><!-- /.col-lg-6 -->
    </div>


  </form>
</div>
</body>
</html>

