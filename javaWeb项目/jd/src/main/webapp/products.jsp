<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.jd.domain.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: zhangbo
  Date: 2020/5/4
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>类别商品页</title>
</head>
<body>
<table align="center" border="1" cellpadding="2px">
    <tr>
        <td>Name</td>
        <td>OrignalPrice</td>
        <td>PromotePrice</td>
        <td>Stock</td>
        <td>CreateDate</td>
    </tr>
<c:forEach items="${requestScope.products}" var="product">
    <tr>
        <td><a href="product.do?id=${product.id}">${product.name}</a></td>
        <td>${product.orignalPrice}</td>
        <td>${product.promotePrice}</td>
        <td>${product.stock}</td>
        <td>${product.createDate}</td>
    </tr>
</c:forEach>
</table>
</body>

</html>
