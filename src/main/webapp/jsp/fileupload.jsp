<%--
  Created by IntelliJ IDEA.
  User: Sheng
  Date: 2019/2/25
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>file upload</title>
</head>
<body>
    <form action="/file/fileupload" method="post" enctype="multipart/form-data">
        <label>文件上传</label>
        <input type="file" name="file">
        <input type="submit" value="上传">
    </form>
</body>
</html>
