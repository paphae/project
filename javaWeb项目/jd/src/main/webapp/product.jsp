<%@ page import="com.jd.domain.Product" %>
<%@ page import="com.jd.domain.Category" %><%--
  Created by IntelliJ IDEA.
  User: zhangbo
  Date: 2020/5/4
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品详情页</title>
</head>
<body>

<p>商品编号：${requestScope.product.id}</p>
<p>商品名称：${requestScope.product.name}</p>
<p>商品原价：${requestScope.product.orignalPrice}</p>
<p>商品折扣价：${requestScope.product.promotePrice}</p>
<p>商品库存：${requestScope.product.stock}</p>
<p>商品类别：${requestScope.category.name}</p>
<p>商品生产日期：${requestScope.product.createDate}</p>
<form action="cookie.do" method="post">
    <input type="hidden" name="pid" value="${requestScope.product.id}">
    数量：<input type="text" name="number" min="0" max="${requestScope.product.stock}" value="0">
    <input type="submit">
</form>
</body>
</html>
