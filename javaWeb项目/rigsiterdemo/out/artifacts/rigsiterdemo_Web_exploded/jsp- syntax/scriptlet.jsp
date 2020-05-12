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
    <!-- 使用scriptlet 拆分代码报错，剪切 -->
<%--为什么scriptlet可以在代码成立的情况下，任意拆分，就为了
    我们可以使用html+css来控制输出内容的样式--%>
    <%
        //每一行是一次循环
        for(int i=0 ;i<=5;i++){
    %>
    <tr>
        <td>
            <%
                out.print(i);
            %>
        </td>
        <td>
            <%
                out.print(i+1);
            %>
        </td>
    </tr>

    <%
    }
    %>
</table>

</body>
</html>
