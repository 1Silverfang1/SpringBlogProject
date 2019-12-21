<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 20/12/19
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Form Submitted</title>
</head>
<body>
<h2>The Student is Confirmed</h2>
<br>
Student First Name : ${studentModel.firstName} Student Last Name : ${studentModel.lastName} with id : ${studentModel.id} from Country : ${studentModel.country}
<br>
<br>
${processResult}
</body>
</html>
