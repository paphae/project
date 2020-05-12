<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhangbo
  Date: 2020/5/8
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示重置密码</title>
</head>
<body>

<c:if test="${requestScope.reset==null||requestScope.reset.equals('')}">
    <c:redirect url="username.jsp"/>
</c:if>
<h1>${requestScope.reset}</h1>
<a href="login.jsp">登录</a>
</body>
</html>
