<%--
  Created by IntelliJ IDEA.
  User: moon
  Date: 2019/8/17
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    请求转发：session.getParameter == <%= session.getAttribute("name")%><br>
    请求转发：request.getAttribute == <%= request.getAttribute("name")%>
</body>
</html>
