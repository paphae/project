<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhangbo
  Date: 2020/5/12
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>打卡信息</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/jsp/deleteClock.do" method="post">
    <table border="1" align="center">
        <tr>
            <td>全选</td>
            <td>id</td>
            <td>uid</td>
            <td>info</td>
            <td>ctime</td>
        </tr>
<c:forEach items="${requestScope.all}" var="info">
        <tr>
            <td><input type="checkbox" name="idArray" value="${info.id}"></td>
            <td>${info.id}</td>
            <td>${info.uid}</td>
            <td>${info.info}</td>
            <td>${info.ctime.toString().substring(0,info.ctime.toString().length()-2)}</td>
            <td><a href="deleteClock.do?id=${info.id}">删除</a></td>
            <td><a href="findByIdClock.do?id=${info.id}">修改</a></td>
        </tr>
</c:forEach>
    </table>
    <input type="submit" value="批量删除">
</form>
</body>
</html>
