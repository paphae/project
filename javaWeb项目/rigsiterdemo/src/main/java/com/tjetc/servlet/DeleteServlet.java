package com.tjetc.servlet;

import com.tjetc.service.EmpService;
import com.tjetc.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jsp/delete.do")
public class DeleteServlet extends HttpServlet {
    EmpService es = new EmpServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empno = req.getParameter("empno");
        boolean flag = es.delete(empno);
        resp.sendRedirect("findAll.do");
    }
}
