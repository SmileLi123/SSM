<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商家添加商品主页</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link href="/css/commodity.css" rel="stylesheet" type="text/css" media="all" />
    <link href="/css/upload.css.css" rel="stylesheet" type="text/css" media="all" />
    <script src="../js/jquery-3.3.1.js"></script>
    <script>
        function warning4(){
            var state=confirm("确认添加？")
            if(state)
                alert("添加成功！")
            else
                return false
        }
    </script>
</head>
<body>

<div class="container">
    <div class="panel-heading">
        <h3>添加商品</h3>
    </div>
    <form method="post" action="/Commodity/addCommodity.form">
        <input type="text" readonly="true"  name="sname" value="${sname}" style="display: none">
        <div class="row">
            <div class="col-lg-6">
                <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px"> 名称</button>
                    </span>
                    <input type="text" class="form-control" placeholder="商品名" name="cname" >
                </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
            <div class="col-lg-6">
                <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" style="width: 120px"> 价格</button>
                    </span>
                    <input type="text" class="form-control" placeholder="商品价格" name="price" >
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
                    <input type="text" class="form-control" placeholder="商品描述" name="describtion">
                </div>
            </div>
        </div>
        <div class="btn-group btn-group-justified" id="btn" role="group" style="margin-top: 15px">
            <div class="btn-group" role="group">
                <a href="/Commodity/shopCommodity.form?sname=${sname}" class="btn btn-default">返回</a>
            </div>
            <div class="btn-group" role="group">
                <input type="submit" class="btn btn-info" value="提交" onclick="return warning4()">
            </div>
        </div>

    </form>
</div>



</body>
</html>
