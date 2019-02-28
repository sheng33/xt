<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<body style="width: 100%; height: 100%;">

    <div align="center">
        <table border="1">
            <tr>
                <td>id</td>
                <td>文件名称</td>
                <td>权限${fileRole}</td>
            </tr>
            <tbody>
            <c:forEach var="userFile" items="${fileList}">
                <tr>
                    <th>${userFile.ID}</th>
                    <th>
                        <a href="/file/download?filename=${userFile.filename}"  target="_blank">
                                ${userFile.filename}
                        </a>
                    </th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
