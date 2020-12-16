<%--
  Created by IntelliJ IDEA.
  User: zoe
  Date: 2020/10/1
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>用户确认订单主页</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <link href="/css/commodity.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
<%  String error=(String)session.getAttribute("error");
    if(error==null||error.equals(""))
        error="";
%>
<div class="container">
  <div class="panel-heading">
    <h3>确认订单</h3>
      <label style="font-size: 18px;color: red;"><%=error %></label>
  </div>
    <%
        session.setAttribute("error",null);
    %>
  <form method="post" action="/Order/addOrder.form">
    <input type="text" readonly="true"  name="uname" value="${user.uname}" style="display: none">
      <input type="text" readonly="true"  name="cid" value="${commodity.cid}" style="display: none">
      <input type="text" readonly="true"  name="gid" value="${scart.gid}" style="display: none">
    <div class="row">
      <div class="col-lg-6">
        <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px"> 店铺名</button>
                    </span>
          <input type="text" class="form-control" readonly="true" name="sname" value="${commodity.sname}">
            </div>
          </div>
            <div class="col-lg-6">
                <div class="input-group">
             <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px"> 商品名</button>
                    </span>
            <input type="text" class="form-control" readonly="true" name="cname" value="${commodity.cname}">
        </div>
      </div>
      </div>
        <div class="row" style="margin-top: 15px">
        <div class="col-lg-6">
        <div class="input-group" >
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px"> 收货人</button>
                    </span>
          <input type="text" class="form-control" placeholder="收货人名称" name="hname"  value="${user.uname}">
        </div>
      </div>

      <div class="col-lg-6">
        <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px"> 联系方式</button>
                    </span>
            <input type="text" class="form-control" placeholder="手机号" name="hphone" value="${user.phone}">
        </div>
      </div>
        </div>
      <div class="row" style="margin-top: 15px">
      <div class="col-lg-6">
        <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px">地址</button>
                    </span>
          <input type="text" class="form-control" placeholder="收货地址" name="haddress" value="${user.address}">
        </div>
      </div>
          <div class="col-lg-6">
              <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px"> 数量</button>
                    </span>
                  <input type="text" class="form-control" placeholder="商品数量" name="num"  value="${scart.num}">
              </div>
          </div>
    </div>
    <div class="btn-group btn-group-justified" id="btn" role="group" style="margin-top: 15px">
        <%
            String gid=(String) session.getAttribute("gid1");
            System.out.println("gid"+gid+"gid");
            if(gid==null||gid.equals("")){
                System.out.println("commodity");
        %>
        <div class="btn-group" role="group">
            <a href="/Commodity/userCommodity.form?uname=${user.uname}" class="btn btn-default">返回</a>
        </div>
        <%
        }else{
            System.out.println("scart");
        %>
        <div class="btn-group" role="group">
            <a href="/Scart/queryByUname.form?uname=${user.uname}" class="btn btn-default">返回</a>
        </div>
        <%
            }
        %>
      <div class="btn-group" role="group">
        <input type="submit" class="btn btn-info" value="提交">
      </div>
    </div>

  </form>
</div>

</body>
</html>
