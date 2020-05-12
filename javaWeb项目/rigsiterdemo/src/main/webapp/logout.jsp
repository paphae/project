<%--
  Created by IntelliJ IDEA.
  User: zhangbo
  Date: 2020/4/28
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
//    session.removeAttribute("username");
    session.invalidate();
%>
<%
    response.sendRedirect("login.jsp");
%>
</body>
</html>
