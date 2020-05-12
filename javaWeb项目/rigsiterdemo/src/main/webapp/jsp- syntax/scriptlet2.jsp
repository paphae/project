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
<table border="1">
<%--我不想用out 不想用java代码进行输出 --%>
<%--第二种 scriptlet  <%= %>
   ！！！注意结束没有 分号
   --%>
    <%
        //每一行是一次循环
        for(int i=0 ;i<=5;i++){
    %>
    <tr>
        <td>
            <%=i %>
        </td>
        <td>
            <%=i+1%>
        </td>
    </tr>

    <%
    }
    %>
</table>

</body>
</html>
