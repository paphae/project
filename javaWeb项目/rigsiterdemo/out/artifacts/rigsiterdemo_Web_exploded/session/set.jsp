<%--
  Created by IntelliJ IDEA.
  User: zhangbo
  Date: 2020/4/28
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    session.setAttribute("msg","0000");
%>
<%
    request.getRequestDispatcher("get.jsp").forward(request,response);
%>
</body>
</html>
