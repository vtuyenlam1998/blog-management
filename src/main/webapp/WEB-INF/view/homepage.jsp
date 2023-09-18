<%--
  Created by IntelliJ IDEA.
  User: defaultuser0
  Date: 9/18/2023
  Time: 9:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Blog List</title>
    <style>
        table {
            border: 1px solid #000;
        }

        th, td {
            border: 1px dotted #555;
        }
    </style>
</head>
<body>
There are ${requestScope.blogs.size()} blog (s) in list.
<table>
    <caption>Blogs List</caption>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${requestScope.blogs}">
        <tr>
            <td>
                <c:out value="${c.id}"/>
            </td>
            <td>
                <a href="info.jsp?id=${c.id}">${c.name}</a>
            </td>
            <td>
                <c:out value="${c.description}"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
