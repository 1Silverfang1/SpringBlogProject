<%@ page import="java.util.ArrayList" %>
<%@ page import="SpringMVC.Model.BlogModel" %>
<%@ page import="org.springframework.web.servlet.ModelAndView" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>This is your new homepage</title>
</head>
<body>
Hey This is your HomePage
All the Form Submitted data will be shown here.
<a href="">Click here for Homepage</a>
<hr>
<hr>
<%
    ArrayList<BlogModel> result= (ArrayList<BlogModel>) request.getAttribute("BlogData");
    for(BlogModel curBlog: result)
    {
%>
<h1><%=curBlog.getBlogPost()%></h1>
<h3><%=curBlog.getAuthorName()%></h3>
<p><%=curBlog.getBlogPost()%></p>
<form action="post/delete" method="post">
    <input type="hidden" value="<%=curBlog.getId()%>" name="BlogId">
    <input type="submit" value="Delete">
</form>
<form action="post/update" method="post">
    <input type="hidden" value="<%=curBlog.getId()%>" name="BlogId">
    <input type="submit" value="Edit">
</form>
<hr>
<%
    }
%>

<br>
<a href="post/create">Click here to add Form</a>
</body>
</html>
