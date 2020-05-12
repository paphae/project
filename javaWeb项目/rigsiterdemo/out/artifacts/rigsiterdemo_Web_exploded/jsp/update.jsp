<%@ page import="com.tjetc.domain.Emp" %><%--
  Created by IntelliJ IDEA.
  User: zhangbo
  Date: 2020/4/29
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../js/jquery-1.9.1.min.js"></script>
    <script>
        $(function () {
            $.get("findDeptno.do",function (data) {
                var str = "";
                var selected = ${requestScope.emp.DEPTNO};
                for (i=0;i<data.length;i++){
                    if (selected==data[i].dEPTNO){
                        str += "<option selected=\"selected\" value='"+data[i].dEPTNO+"'>"+data[i].dNAME+"</option>";
                    }else {
                        str += "<option value='"+data[i].dEPTNO+"'>"+data[i].dNAME+"</option>";
                    }
                }
                $("#deptno").html(str);
            },"json");
            $.get("findMgr.do",function (data) {
                var str = "";
                var mgr = ${requestScope.emp.MGR};
                for (i=0;i<data.length;i++){
                    if (mgr==data[i].eMPNO){
                        str += "<option selected='selected' value='"+data[i].eMPNO+"'>"+data[i].eNAME+"</option>";
                    }else {
                        str += "<option value='"+data[i].eMPNO+"'>"+data[i].eNAME+"</option>";
                    }
                }
                str += "<option value=''>null</option>";
                $("#mgr").html(str);
            },"json");
        })
    </script>

</head>
<body>
    <form action="update.do" method="post">
<%--        <input type="hidden" name="empno" value="<%=emp.getEMPNO()%>">--%>
            员工编号<input name="empno" type="text" readonly="readonly" value="${requestScope.emp.EMPNO}"><br>
        姓名<input name="ename" type="text" value="${requestScope.emp.ENAME}"><br>
        职位<input type="text" name="job" value="${requestScope.emp.JOB}"><br>
        领导编号<select name="mgr" id="mgr"></select><br>
        入职时间<input type="date" name="hiredate" value="${requestScope.emp.HIREDATE}"><br>
        薪水<input type="text" name="sal" value="${requestScope.emp.SAL}"><br>
        奖金<input type="text" name="comm" value="${requestScope.emp.COMM}"><br>
        部门编号<select name="deptno" id="deptno" value="${requestScope.emp.DEPTNO}">

        </select>
        <br><input type="submit" value="提交修改">
    </form>
</body>
</html>
