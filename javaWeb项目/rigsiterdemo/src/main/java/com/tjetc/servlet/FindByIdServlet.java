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
import java.util.List;

@WebServlet("/jsp/findById.do")
public class FindByIdServlet extends HttpServlet {
    EmpService es = new EmpServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empno = request.getParameter("empno");
        Emp emp = es.findById(Integer.valueOf(empno));
        request.setAttribute("emp",emp);
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }
}
