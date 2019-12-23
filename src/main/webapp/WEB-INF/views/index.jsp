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
<form method="post" action="post/view">
<h2><input style="text-align:center;background: none;border: none;font-size: larger;cursor: pointer" type="submit" value="<%=curBlog.getBlogTitle()%>"></h2>
    <input type="hidden" value="<%=curBlog.getId()%>" name="BlogId">
</form>
<h3><%=curBlog.getAuthorName()%></h3>
<% String blog = curBlog.getBlogPost();
String blogExcrept="";
if(blog.length()>50)
{
   blogExcrept = blog.substring(0,49);
}
else
{
    blogExcrept=blog;
}
%>
<p><%=blogExcrept%></p>
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
