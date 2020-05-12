<%--
  Created by IntelliJ IDEA.
  User: sun
  Date: 2020/4/28
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%-- contentType="text/html;charset=UTF-8"
    text文本内容是html的。 内容编码是utf-8(世界编码，可以支持中文。（gbk，gb2312）)
   response.setcontentType("text/html;charset=UTF-8") 解决过out在页面打印乱码。
   language="java" 语言是java
   但是我们看见都是html语言。
   jsp可以镶嵌java代码块。
   scriptlet 脚本小程序。 把java 镶嵌在jsp上。
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- idea 自检 --%>
<%

    int sum = 0;
%>

<%
    for(int i =1;i<=100;i++){
%>
<%
    sum+=i;
%>
<%
    }
%>
<H1>
<%
    //jsp 给我们创建好的  printwriter的对象   response.getWriter()
    out.print(sum);
%>
</H1>
</body>
</html>
