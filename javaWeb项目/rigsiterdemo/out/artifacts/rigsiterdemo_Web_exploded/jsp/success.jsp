<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.tjetc.domain.Emp" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tjetc.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: sun
  Date: 2020/4/28
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../js/jquery-1.9.1.min.js"></script>
    <script>
        $(function () {
            $.get("findDeptno.do",function (data) {
                var str = "";
                for (i=0;i<data.length;i++){
                    str += "<option value='"+data[i].dEPTNO+"'>"+data[i].dNAME+"</option>"
                }
                $("#deptno").html(str);
            },"json");
            $.get("findMgr.do",function (data) {
                var str = "";
                for (i=0;i<data.length;i++){
                    if (data[i].eMPNO==<%=((User)session.getAttribute("user")).getId()%>){
                        str += "<option selected value='"+data[i].eMPNO+"'>"+data[i].eNAME+"</option>"
                    }else {
                        str += "<option value='"+data[i].eMPNO+"'>"+data[i].eNAME+"</option>"
                    }
                }
                str += "<option value=''>null</option>"
                $("#mgrName").html(str);
            },"json");
        });
    </script>
</head>
<body>

<c:if test="${sessionScope.user==null}">
    <c:redirect url="../login.jsp"/>
</c:if>
<h1>欢迎：${sessionScope.user.username}</h1>
<a href="../logout.jsp">注销</a>
<form action="findAll.do" method="post">
    <input type="text" name="key" value="${param.key}" placeholder="全字匹配">
    <input type="submit" value="搜索">
</form>

<c:if test="${requestScope.msg!=null}">
    <c:out value="${requestScope.msg}"/>
    ${sessionScope.remove("msg")}
</c:if>

<c:if test="${sessionScope.msg!=null}">
    <c:out value="${sessionScope.msg}"/>
    ${sessionScope.remove("msg")}
</c:if>
<form action="insert.do" method="post">
<table border="1" align="center">
    <tr>
        <td>全选</td>
        <td>EMPNO</td>
        <td>ENAME</td>
        <td>JOB</td>
        <td>MGR</td>
        <td>HIREDATE</td>
        <td>SAL</td>
        <td>COMM</td>
        <td>DEPTNO</td>
    </tr>

<c:forEach items="${requestScope.emps}" var="emp">
    <tr>
        <td><input type="checkbox"name="empnoArray" value="${emp.EMPNO}"></td>
        <td>${emp.EMPNO}</td>
        <td>${emp.ENAME}</td>
        <td>${emp.JOB}</td>
        <td>${emp.MGR}</td>
        <td>${emp.HIREDATE}</td>
        <td>${emp.SAL}</td>
        <td>${emp.COMM}</td>
        <td>${emp.DEPTNO}</td>
        <td><a href="delete?empno=${emp.EMPNO}">删除</a></td>
        <td><a href="findById.do?empno=${emp.EMPNO}">修改</a></td>
    </tr>

</c:forEach>
    <tr>
            <td></td>
            <td><input type="text" name="emp" readonly="readonly" placeholder="由系统分配"></td>
            <td><input type="text" name="emp"></td>
            <td><input type="text" name="emp"></td>
            <td><select name="emp" id="mgrName"></select></td>
            <td><input type="date" name="emp"></td>
            <td><input type="text" name="emp"></td>
            <td><input type="text" name="emp"></td>
<%--            <td><input type="text" name="emp" list="deptno"></td>--%>
<%--            <datalist id="deptno">--%>
<%--                <option value="10">10</option>--%>
<%--                <option value="20">20</option>--%>
<%--                <option value="30">30</option>--%>
<%--            </datalist>--%>
            <td>
                <select name="emp" id="deptno"></select>
            </td>

    </tr>

</table>
    <c:choose>
        <c:when test="${sessionScope.user.id eq 1}">
            <a href="findAllClockInfo.do"><button type="button">打卡信息</button></a>
        </c:when>
        <c:otherwise>
            <a href="clock.jsp"><button type="button">打卡</button></a>
        </c:otherwise>
    </c:choose>
    <input type="submit" value="批量删除" formaction="deleteArray.do">
    <input type="submit" value="添加">
</form>
</body>
</html>
