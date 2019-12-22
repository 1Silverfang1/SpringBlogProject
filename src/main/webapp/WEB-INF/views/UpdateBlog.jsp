<%@ page import="SpringMVC.Model.BlogModel" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 22/12/19
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Update BLog</title>
</head>
<body>
 <h2>Update your Blog Here</h2>
<form:form action="updateConfirm" modelAttribute="BlogObject" method="post" autocomplete="false">
<form:input path="authorName"></form:input>
    <form:input path="blogTitle"></form:input>
    <form:input path="blogPost"></form:input>
<%--    <input:hidden path="id" name="abc"/>--%>
    <form:hidden path="id"/>
    <form:hidden path="country"/>
     <input type="submit" value="update">
 </form:form>
${BlogId};
</body>
</html>
