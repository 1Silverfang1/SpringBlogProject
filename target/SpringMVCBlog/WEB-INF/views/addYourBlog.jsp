<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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
<span>
    ${processResult}
</span>
<form:form action="/SpringMVCBlog_war_exploded/post/create" modelAttribute="BlogModel" method="post" >
    First Name: <form:input path="firstName" autocomplete="false"/>
    <form:errors path="firstName" /> <br>
    Last Name: <form:input path="secondName" autocomplete="false"/>
    <form:errors path="secondName" /><br>
    Student Id: <form:input path="id" autocomplete="false"/>
    <form:errors path="id" /><br>
    Country: 
    <form:select path="country">
        <form:option value="INDIA" label="IN"></form:option>
        <form:option value="PAKISTAN" label="PK"></form:option>
        <form:option value="GERMANY" label="GM"></form:option>
        <form:option value="UNITED STATES" label="USA"></form:option>
    </form:select>
<form:textarea path="blogPost" ></form:textarea>
<input type="submit" value="Submit">
</form:form>
</body>
</html>
