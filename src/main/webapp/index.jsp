<%@ page contentType="text/html; charset=utf-8"%>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<script src="js/jquery-2.1.1.min.js" type="text/javascript"></script>
<script>
    $('#login-button').click(function (event) {
        event.preventDefault();
        $('form').fadeOut(500);
        $('.wrapper').addClass('form-success');
    });
    function tijiao(){
        document.getElementById("loginuser").submit();//js原生方式表单提交
    }
</script>
<body>

<%--<div class="htmleaf-container">--%>
    <div class="wrapper">
        <div class="container">
            <h1>数据管理系统</h1>

            <form class="form"  action="/checkLogin" method="post" id="loginuser">
                <input type="text" placeholder="Username" name="username">
                <input type="password" placeholder="Password" name="password">
            </form>
                <button type="submit" id="login-button" onclick="tijiao()">登陆</button>
                <button onclick="window.location.href='/regist'">注册</button>

        </div>

        <ul class="bg-bubbles">
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
<%--</div>--%>


</body>
</html>