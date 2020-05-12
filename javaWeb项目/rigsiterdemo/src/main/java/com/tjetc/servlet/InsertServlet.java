package com.tjetc.servlet;

import com.tjetc.service.EmpService;
import com.tjetc.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jsp/insert.do")
public class InsertServlet extends HttpServlet {
    EmpService es = new EmpServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] emps = req.getParameterValues("emp");
        boolean flag = es.insert(emps[0], emps[1], emps[2], emps[3], emps[4],
                emps[5], emps[6], emps[7]);
        if(flag){
            req.getSession().setAttribute("msg","添加成功");
        }else{
            req.getSession().setAttribute("msg","添加失败");
        }
        resp.sendRedirect("findAll.do");
    }
}
