<%--
  Created by IntelliJ IDEA.
  User: zhangbo
  Date: 2020/5/2
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品类别页面</title>
    <script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script>
        $(function () {
            $.get("findCategory.do",function (data) {
                var str = "";
                for (i=0;i<data.length;i++){
                    str+="<li><a href=\"findProducts.do?name="+data[i].name+"\">"+data[i].name+"</a></li>"
                }
                $("#categories").html(str);
            },"json");
        });
    </script>
</head>
<body>
    <ul id="categories">

    </ul>
</body>
</html>
