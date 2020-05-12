<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.tjetc.domain.Encrypted" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: zhangbo
  Date: 2020/5/8
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>找回密码</title>
</head>
<body>
<c:if test="${requestScope.encrypteds==null}">
    <c:redirect url="username.jsp" />
</c:if>
<form action="<%=request.getContextPath()%>/reset.do" method="post">
    <input type="text" readonly value="${param.get("username")}"><br>
    <c:forEach items="${requestScope.encrypteds}" var="encryted">



    <p>${encryted.problem}</p>
    <input type="hidden" name="uid" value="${encryted.uid}">
    <input type="text" name="answer" placeholder="答案">
    <input type="hidden" name="realAnswer" value="${encryted.answer}">
    </c:forEach>
    <input type="submit" value="找回">
</form>
</body>
</html>
