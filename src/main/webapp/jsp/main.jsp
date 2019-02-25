<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<div>
    <strong> welcome,${role}${sessionScope.user.username}! </strong>
</div>
this is success page!

<a href="${pageContext.request.contextPath}/anotherpage">点我跳到另一个页面</a>
<a href="/file">上传</a>
<form action="/file/download" method="post">
    <input type="text" id="filename" name="filename"/>
    <input type="submit" value="下载">
</form>
<form action="${pageContext.request.contextPath}/outLogin">
    <table>
        <tr>
            <td><input type="submit" value="退出登录"></td>
        </tr>
    </table>
</form>
</body>
</html>