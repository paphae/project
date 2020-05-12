package com.tjetc.servlet;

import com.tjetc.service.EmpService;
import com.tjetc.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jsp/deleteArray.do")
public class DeleteArrayServlet extends HttpServlet {
    EmpService es = new EmpServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] empnoArrays = req.getParameterValues("empnoArray");

//        boolean flag = true;
//        for (String empnoArray : empnoArrays) {
//            flag = es.delete(empnoArray);
//            if(!flag){
//                req.setAttribute("msg","删除失败"+empnoArray);
//                break;
//            }
//        }
        boolean flag = es.deleteArray(empnoArrays);
        if (!flag) {
            req.getSession().setAttribute("msg", "删除失败");
        }
        resp.sendRedirect("findAll.do");
    }
}
