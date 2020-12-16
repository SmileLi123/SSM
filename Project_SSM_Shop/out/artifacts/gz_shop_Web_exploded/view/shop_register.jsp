<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: zoe
  Date: 2020/9/10
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商家注册页面</title>
    <link href="/css/register.css" rel='stylesheet' type='text/css' media="all" />
    <script src="../js/jquery-3.3.1.js"></script>
    <script >
        $(function(){
            $("#sname").blur(function(){
                var sname=$("#sname").val();
                $.ajax({
                    url:"/Shop/check.form",
                    type:"POST",
                    dataType:"text",
                    data:{sname:sname},
                    success:function(data){
                        //alert(uname);
                        if(data=="0"){
                            $("#s_sname").html("<font color='red'>该店铺名已被注册</font>");
                        }
                        else if(data=="1")
                            $("#s_sname").html("<font color='red'>店铺名不能为空</font>");
                        else
                            $("#s_sname").html("<font color='green'>店铺名可用</font>");
                    },
                    error:function(){
                        alert("失败")
                    },
                })
            })
        })
        $(function(){
            $("#password").blur(function(){
                var password=$("#password").val();
                $.ajax({
                    url:"/Shop/checkpd.form",
                    type:"POST",
                    dataType:"text",
                    data:{password:password},
                    success:function(data){
                        //alert(uname);
                        if(data=="1")
                            $("#s_password").html("<font color='red'>密码不能为空</font>");
                        else
                            $("#s_password").html("<font ></font>");
                    },
                    error:function(){
                        alert("失败")
                    },
                })
            })
        })
        $(function(){
            $(".sign-in").click(function(){
                var sname=$("#sname").val();
                var password=$("#password").val();
                var phone=$("#phone").val();
                $.ajax({
                    url:"/Shop/checkall.form",
                    type:"POST",
                    dataType:"text",
                    data:{sname:sname,password:password,phone:phone},
                    success:function(data){
                        //alert(uname);
                        if(data=="0"){
                            alert("店铺名不能为空")
                        }
                        if(data=="1")
                            alert("密码不能为空")
                        if(data=="2")
                            alert("手机号不能为空")
                        if(data=="3")
                            alert("注册成功！")
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
<div class="content1 shop">
    <form method="get" action="/Shop/register.form">
    <input  id="sname"type="text" name="sname" placeholder="店铺名"value=${sname}>
        <p  id="s_sname"></p>
        <p style="color: red ;height:0px;line-height: 30px">注：店铺名一经注册，不可更改</p>
        <input id="password" type="password" name="password" placeholder="密码" value=${password}><p style="line-height: 20px" id="s_password"></p>
        <input type="text" name="phone" placeholder="手机号" id="phone">  <br/>
        <textarea name="describtion" rows="5" cols="35">请输入店铺简介
        </textarea>
        <div class="button-row">
            <input type="submit" class="sign-in" value="注册" id="sign-in">
            <a href="/index.jsp" class="reset" value="返回">返回</a>
        </div>
        <%
            session.removeAttribute("sname");
            session.removeAttribute("password");
        %>
    </form>
</div>
</body>
</html>
