<%@ page import="java.util.ArrayList" %>
<%@ page import="SpringMVC.Model.BlogModel" %>
<%@ page import="org.springframework.web.servlet.ModelAndView" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<h1><%=curBlog.getAuthorName()%></h1>
<p><%=curBlog.getBlogPost()%></p>
<hr>
<%
    }
%>
<%--    <c:forEach items="${BlogData}" var="BlogData">--%>
<%--        ${BlogData}--%>
<%--    </c:forEach>--%>
<br>
<a href="post/create">Click here to add Form</a>
</body>
</html>
