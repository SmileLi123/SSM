<%@ page import="java.util.Objects" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册页面</title>
    <link href="/css/register.css" rel='stylesheet' type='text/css' media="all" />
    <script src="../js/jquery-3.3.1.js"></script>
    <script type="text/javascript">
    $(function(){
     $("#uname").blur(function(){
            var uname=$("#uname").val();
            $.ajax({
                url:"/User/check.form",
                type:"POST",
                dataType:"text",
                data:{uname:uname},
                success:function(data){
                //alert(uname);
                if(data=="0"){
                    $("#s_uname").html("<font color='red'>该用户名已被注册</font>");
                }
                else if(data=="1")
                    $("#s_uname").html("<font color='red'>用户名不能为空</font>");
                else
                    $("#s_uname").html("<font color='green'>用户名可用</font>");
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
                url:"/User/checkpd.form",
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
            var uname=$("#uname").val();
            var password=$("#password").val();
            var phone=$("#phone").val();
            var address=$("#address").val();
            $.ajax({
                url:"/User/checkall.form",
                type:"POST",
                dataType:"text",
                data:{uname:uname,password:password,phone:phone,address:address},
                success:function(data){
                    //alert(uname);
                    if(data=="0"){
                        alert("用户名不能为空")
                    }
                     if(data=="1")
                        alert("密码不能为空")
                     if(data=="2")
                        alert("手机号不能为空")
                     if(data=="3")
                        alert("地址不能为空")
                     if(data=="4")
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
    <form method="get" action="/User/register.form">
        <input  type="text"  id="uname" name="uname"  placeholder="用户名" value="${uname}">
        <p  id="s_uname"></p>
        <p style="color: red ;height:0px;line-height: 30px">注：用户名一经注册，不可更改</p>
        <input  type="password" id="password" name="password"  placeholder="密码" value="${password}" ><p style="line-height: 20px" id="s_password"></p><br/>
        <input  style="margin-top: 10px" type="text" name="phone"  placeholder="手机号" id="phone" value="${phone}"></br>
        <input type="text" name="email"  placeholder="邮箱" value="${email}"></br>
        <input type="text" name="address" placeholder="地址"id="address"></br>
        <div class="button-row">
            <input type="submit" class="sign-in" value="注册"  >
            <a href="/index.jsp" class="reset" value="返回">返回</a>
        </div>
        <%
            session.removeAttribute("uname");
            session.removeAttribute("password");
            session.removeAttribute("phone");
            session.removeAttribute("email");
        %>
    </form>
</div>
</body>
</html>
