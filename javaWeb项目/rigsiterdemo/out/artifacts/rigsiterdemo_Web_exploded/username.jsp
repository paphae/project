<%--
  Created by IntelliJ IDEA.
  User: zhangbo
  Date: 2020/5/8
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>账号</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/findPassword.do" method="post">
    <input type="text" name="username" placeholder="账号">
    <input type="submit">
</form>
</body>
</html>
