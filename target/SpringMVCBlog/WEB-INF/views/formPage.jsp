<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 20/12/19
  Time: 12:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
<form action="processMyForm" method="post">
    <input type="text" name="FirstName" placeholder="Enter your FirstName">
    <input type="text" name="LastName" placeholder="Enter your Last Name">
<input type="submit">
</form>
<form action="processMyFormV2" method="post">
    <input type="text" name="FirstName" placeholder="Enter your FirstName">
    <input type="text" name="LastName" placeholder="Enter your Last Name">
    <input type="submit">
</form>
</body>
</html>
