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
<a href="/person">个人中心</a>

<a href="${pageContext.request.contextPath}/anotherpage">点我跳到另一个页面</a>
<form action="/file/fileupload" method="post" enctype="multipart/form-data">
    <label>文件上传</label>
    <input type="file" name="file">
    <input type="submit" value="上传">
</form>

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



<iframe src="/file" width="100%" height="50%"/>
</body>
</html>