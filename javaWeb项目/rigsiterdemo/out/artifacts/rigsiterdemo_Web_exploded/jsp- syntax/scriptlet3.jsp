<%--
  Created by IntelliJ IDEA.
  User: sun
  Date: 2020/4/28
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- 123456 都到齐了-->
<%-- <%%> 每次请求的时候，会重新执行 --%>
A:
<%
  int a  = 1;
%>
<%=a++ %>
<HR>
B：
<%--第三种scriptlet  <%! %>
  1.声明的变量只第一次访问的时候执行，以后再范围不会重启创建。
  2.声明方法 (命令禁止)
 --%>

<%!
    int b   = 1;
%>
<%=b++ %>
<%!
    public String print(){
        return  "hello world";
    }
%>
<%
    String print = print();
    out.print(print);
%>
</body>
</html>
