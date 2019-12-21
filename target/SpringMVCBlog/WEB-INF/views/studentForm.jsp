<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Form</title>
    <style>
        .error
        {
            color: red;
        }
    </style>
</head>
<body>
<form:form action="processForm" modelAttribute="studentModel" >
    First Name: <form:input path="firstName"/>
    <form:errors path="firstName" /> <br>
    Last Name: <form:input path="lastName"/>
    <form:errors path="lastName" /><br>
    Student Id: <form:input path="id"/>
    <form:errors path="id" /><br>
    Country: 
    <form:select path="country">
        <form:option value="INDIA" label="IN"></form:option>
        <form:option value="PAKISTAN" label="PK"></form:option>
        <form:option value="GERMANY" label="GM"></form:option>
        <form:option value="UNITED STATES" label="USA"></form:option>
    </form:select>
<input type="submit" value="Submit">
</form:form>
</body>
</html>
