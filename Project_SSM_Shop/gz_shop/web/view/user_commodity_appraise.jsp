<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品评价页面</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="panel-heading">
        <h3><c style="float: left;width: 95%">商品评价</c></h3>
        <a href="/Commodity/userCommodity.form?uname=${uname}" class=" btn btn-info">返回</a>
    </div>
    <div class="panel panel-default ">
        <table class="table">
            <tr><td width="80">序号</td><td width="80">用户</td><td >等级</td><td>描述</td></tr>
            <c:forEach items="${lista}" varStatus="status">
                <c:set var="et" value="${status.current}"/>                       
                <tr><td>${status.count}</td><td>${et.uname}</td><td>${et.grade}</td><td>${et.info}</td></tr>
            </c:forEach>
        </table>
    </div>
</div>


<script src="../js/jquery-3.3.1.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>

</body>
</html>