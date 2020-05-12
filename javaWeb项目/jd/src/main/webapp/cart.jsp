<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page import="com.jd.domain.Cart" %>
<%@ page import="com.jd.service.ProductService" %>
<%@ page import="com.jd.service.impl.ProductServiceImpl" %>
<%@ page import="com.jd.domain.Product" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.alibaba.fastjson.JSON" %><%--
  Created by IntelliJ IDEA.
  User: zhangbo
  Date: 2020/5/4
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车界面</title>
    <script src="js/jquery-1.9.1.min.js"></script>
    <script>
        $(function () {
            $(".minus").click(function () {
                var s = {pid:this.value,step:-1};
                $.get("update.do",s,function (data) {
                    $("#number"+s.pid).val(data.number);
                    var price = $("#price"+s.pid).text();
                    $("#subtotal"+s.pid).text(parseFloat(price)*parseInt(data.number));
                },"json");
            });
            $(".add").click(function () {
                var s = {pid:this.value,step:1};
                $.get("update.do",s,function (data) {
                    $("#number"+s.pid).val(data.number);
                    var price = $("#price"+s.pid).text();
                    $("#subtotal"+s.pid).text(parseFloat(price)*parseInt(data.number));
                },"json");
            });
        });
    </script>
</head>
<body>
<form action="deleteArray.do" method="get">
<table>
    <tr>
    <td>全选</td>
    <td>名称</td>
    <td>单价</td>
    <td>数量</td>
    <td>小计</td>
    <td></td>
    </tr>
    <sql:setDataSource var="db" user="root" password="lh0812"
                       url="jdbc:mysql://127.0.0.1:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC"
                       driver="com.mysql.cj.jdbc.Driver"/>
    <c:forEach items="${requestScope.carts}" var="cart">
        <sql:query dataSource="${db}" sql="SELECT * FROM product where id=${cart.key}"
                   var="products" />
        <c:forEach var="product" items="${products.rows}">
            <tr>
        <td><input type="checkbox" name="pids" value="${product.id}"></td>
        <td>${product.name}</td>
        <td id="price${product.id}">${product.promotePrice}</td>
        <td>
            <button type="button" class="minus" value="${product.id}">-</button>
            <input id="number${product.id}" type="text" min="0" name="numbers" value="${cart.value}">
            <button type="button" class="add" value="${product.id}">+</button>
        </td>
        <c:set value="${cart.value}" scope="page" var="num"/>
        <c:set value="${product.promotePrice}" scope="page" var="price"/>
        <td id="subtotal${product.id}"><c:out value="${num*price}"/></td>
        <td><a href="deleteArray.do?pids=${product.id}">删除</a></td>
    </tr>
        </c:forEach>
    </c:forEach>
</table>
    <input type="submit" value="选中删除">
    <input type="submit" value="提交订单" formaction="login.jsp" formmethod="post">
</form>
</body>
</html>
