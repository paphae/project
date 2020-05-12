<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhangbo
  Date: 2020/5/12
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="clock" value="${requestScope.clock}"/>
<form action="clockUpdate.do" method="post">
    id<input name="id" type="text" readonly="readonly" value="${clock.id}"><br>
    uid<input name="uid" type="text" value="${clock.uid}"><br>
    打卡信息<input type="text" name="info" value="${clock.info}"><br>
    打卡时间<input type="datetime-local" name="ctime" value="${clock.ctime.toLocalDateTime()}"><br>
</select>
    <br><input type="submit" value="提交修改">
</form>
</body>
</html>
