<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>登录界面</title>
  <link href="/css/login.css" rel='stylesheet' type='text/css' media="all" />
  <script src="../js/jquery-3.3.1.js"></script>
  <script >
    $(function(){
      $(document).on('click', '#submit', function () {
        var loginname=$("#loginname").val();
        var password=$("#password").val();
        var people=$("#people").val();
        $.ajax({
          url:"/logincheck.form",
          type:"POST",
          dataType:"text",
          data:{loginname:loginname,password:password,people:people},
          success:function(data){
            //alert(uname);
            if(data=="0"){
             alert("用户名不能为空");
            }
            else if(data=="1")
             alert("密码不能为空");
            else if(data=="2")
              alert("用户名或密码错误，请重新登录");
          },
          error:function(){
            alert("失败")
          },
        })
      })
    })
  </script >
</head>
<body>
<div class="log">
  <div class="content1">
    <h2>网上购物系统</h2>

    <form action="/login.form" method="post">

      <input type="text" name="loginname" placeholder="账号" id="loginname">
      <input type="password" name="password" placeholder="密码"  id="password"><br>
      <select name="people" id="people">
        <option value="user" >用户</option>
        <option value="admin" >店家</option>
      </select><br>
      <a href="view/user_register.jsp" style="padding-right: 150px ;line-height:50px ;">用户注册</a>
      <a href="view/shop_register.jsp" >店家注册</a>
      <div class="button-row" style="margin-top: 0">
        <input type="submit" class="sign-in" value="登录" id="submit">
        <input type="reset" class="reset" value="重置">
      </div>
    </form>
  </div>
</div>
</body>
</html>
