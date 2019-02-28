<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <script src="../layui/layui.js"></script>
    <script type="application/javascript">
        function tijiao(){
            document.getElementById("loginuser").submit();//js原生方式表单提交
        }
    </script>
    <style type="text/css">
        *{margin: 0;
        padding: 0;}
        body{
            width: 1100px;
            height: 900px;
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 0 auto;

            background-image: url("images/main.jpg");
        }
        .main{width: 500px;
            height: 300px;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: white;
            flex-flow: column;
            opacity: 0.4;
        }
        .mainbtn{
            opacity:1;
            margin-top: 20px;
            margin-left: 110px;
        }
    </style>
</head>

<body>
    <div class="main">
        <form action="/checkLogin" method="post" id="loginuser" style="margin-left: -20px;opacity:1;">
            <div class="layui-form-item">
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-block">
                    <input type="text" name="username" lay-verify="title" autocomplete="off" placeholder="请输入用户名" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">密码框</label>
                <div class="layui-input-block">
                    <input type="password" name="password" placeholder="请输入密码" autocomplete="off" class="layui-input">
                </div>
            </div>
        </form>
        <div class="mainbtn">
            <button class="layui-btn layui-btn-normal layui-btn-radius layui-btn-lg" onclick="tijiao()">登陆</button>
            <button class="layui-btn layui-btn-warm layui-btn-radius layui-btn-lg" onclick="window.location.href='/regist'">注册</button>
        </div>
    </div>



   </body>
</html>