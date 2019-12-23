<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page import="SpringMVC.Model.BlogModel" %><%--
  Created by IntelliJ IDEA.
  User: root
  Date: 20/12/19
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Blog Deletion</title>
</head>
<body>
<%
BlogModel curBlog = (BlogModel)request.getAttribute("BlogObject");%>
<h2>Are you Sure You want to delete the Following Post</h2>
<br>
<br>
<br>
<h2><%=curBlog.getAuthorName()%></h2>
<hr>
<p><%=curBlog.getBlogPost()%></p>
<hr>
<form action="/SpringMVCBlog_war_exploded/post/delete/Confirm" method="post">
    <input type="hidden" value="<%=curBlog.getId()%>" name="blogId">
    <input type="submit" value="delete">
</form>
</body>
</html>
