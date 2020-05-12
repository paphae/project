package com.tjetc.servlet;

import com.tjetc.domain.Emp;
import com.tjetc.service.EmpService;
import com.tjetc.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jsp/update.do")
public class UpdateServlet extends HttpServlet {
    EmpService es = new EmpServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empno = req.getParameter("empno");
        String ename = req.getParameter("ename");
        String job = req.getParameter("job");
        String mgr = req.getParameter("mgr");
        String hiredate = req.getParameter("hiredate");
        String sal = req.getParameter("sal");
        String comm = req.getParameter("comm");
        String deptno = req.getParameter("deptno");
        boolean flag = es.updateByEmpno(empno, ename, job, mgr, hiredate, sal, comm, deptno);
        if(flag){
            req.getSession().setAttribute("msg","修改成功");
        }else{
            req.getSession().setAttribute("msg","修改失败");
        }
        resp.sendRedirect("findAll.do");
    }
}
