<%--
  Created by IntelliJ IDEA.
  User: defaultuser0
  Date: 9/18/2023
  Time: 9:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Blog</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h2>Add New Blog</h2>
<form method="post" action="/blog/create">
    <fieldset>
        <legend>
            Blog Form
        </legend>
        <table>
            <tr>
                <td><label for="name">Name:</label></td>
                <td><input type="text" id="name" name="name" size="45" title="letter and number allowed"></td>
            </tr>
            <tr>
                <td><label for="description">Description:</label></td>
                <td><input type="text" id="description" name="description" size="45" title="letter and number allowed"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <a href="/blog"><button type="button">Cancel</button></a>
                    <button type="submit">Create</button>
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
