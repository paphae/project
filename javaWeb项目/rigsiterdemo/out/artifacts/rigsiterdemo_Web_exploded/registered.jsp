<%--
  Created by IntelliJ IDEA.
  User: zhangbo
  Date: 2020/5/7
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
    <script>
        // 页面加载执行
        $(function () {
            $("#username").blur(function () {
                var username = $("#username").val();
                $.ajax({
                    // async:false,
                    url:"findByUsername",
                    type:"get",
                    data:{"username": username},
                    success:function (msg) {
                        if (msg=="1"){
                            $("#msg").html("用户存在");
                        }
                        else {
                            $("#msg").html("用户名可用");
                        }
                    },
                    error:function () {
                        alert("出错啦...")
                    },
                    dataType:"text"
                })
            })
        });
        // $.ajax({
        //     url:"ajaxServlet1111" , // 请求路径
        //     type:"POST" , //请求方式
        //     //data: "username=jack&age=23",//请求参数
        //     data:{"username":"jack","age":23},
        //     success:function (data) {
        //         alert(data);
        //     },//响应成功后的回调函数
        //     error:function () {
        //         alert("出错啦...")
        //     },//表示如果请求响应出现错误，会执行的回调函数
        //
        //     dataType:"text"//设置接受到的响应数据的格式
        // });

    </script>
</head>
<body>
<form action="registered.do" method="post">
    账号：<input type="text" name="username" id="username"><span id="msg"></span><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="注册">
</form>
</body>
</html>
