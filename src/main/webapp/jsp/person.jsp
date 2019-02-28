<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<head>
    <meta charset="utf-8">
    <title>Insert title here</title>
</head>
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