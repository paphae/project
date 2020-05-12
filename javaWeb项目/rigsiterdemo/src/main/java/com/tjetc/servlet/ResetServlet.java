package com.tjetc.servlet;

import com.tjetc.service.UserService;
import com.tjetc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reset.do")
public class ResetServlet extends HttpServlet {
    UserService us = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String answer = req.getParameter("answer");
        String realAnswer = req.getParameter("realAnswer");
        String uid = req.getParameter("uid");
        if (realAnswer.equals(answer)){
            String reset = us.reset(uid);
            req.setAttribute("reset",reset);
            req.getRequestDispatcher("echo.jsp").forward(req,resp);
        }else {
            resp.sendRedirect(req.getContextPath()+"/username.jsp");
        }
    }
}
