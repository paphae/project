<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhangbo
  Date: 2020/4/30
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script>
        $(function () {
            $("#code").click(function () {
                var time = new Date;
                $("#code").prop("src","code.do?time="+time);
            })
        });
    </script>
</head>
<body>
<c:choose>
    <c:when test="${applicationScope.count==null}">
        <c:set value="1" var="count" scope="application"/>
    </c:when>
    <c:otherwise>
        <c:set value="${applicationScope.count+1}" var="count" scope="application"/>
    </c:otherwise>
</c:choose>

<h1>访问次数：${applicationScope.count}</h1>
<%
%>
    <form action="login.do" method="post">
        账号：<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        验证码：<input type="text" name="code" ><img id="code" src="code.do" alt="无"><br>
        <input type="submit" value="注册" formaction="registered.jsp">
        <input type="submit" value="忘记密码" formaction="<%=request.getContextPath()%>/findPassword.do">
        <input type="submit" value="登录">
    </form>
</body>
</html>
