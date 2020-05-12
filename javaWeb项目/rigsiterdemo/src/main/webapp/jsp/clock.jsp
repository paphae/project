<%--
  Created by IntelliJ IDEA.
  User: zhangbo
  Date: 2020/5/11
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>打卡</title>
    <script src="../js/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        function add0(t){
            if(t<0){
                t = "0"+t;
            }
            return t;
        }
        function fun(){
            var date = new Date();
            var h = date.getHours();
            if(h<10){
                h="0"+h;
            }
            var min = date.getMinutes();
            if(min<10){
                min="0"+min;
            }
            var s = date.getSeconds();
            if(s<10){
                s="0"+s;
            }
            var time_str = h+":"+min+":"+s;
            document.getElementById("time").innerHTML = time_str;
            $("#rt").val(new Date().getTime());
        }
        var set_time = window.setInterval(fun,1000);
    </script>
    <script>
        $(function () {
            $("#flag").click(function () {
                var today = new Date();
                if (today.getHours()>0 && today.getHours()<24){
                    $("#flag").val(today.getTime());
                    return true;
                }else {
                    return false;
                }
            })
        })
    </script>
</head>
<body>
<form action="clock.do" method="post">
    <input type="hidden" name="id" value="${sessionScope.user.id}">
    <input type="text" name="username" readonly value="${sessionScope.user.username}">
    <input type="text" name="info" placeholder="打卡信息">
    <span id="time"></span><input type="hidden" id="rt" name="time" value="">
    <input type="submit" id="flag" value="打卡">
</form>
</body>
</html>
