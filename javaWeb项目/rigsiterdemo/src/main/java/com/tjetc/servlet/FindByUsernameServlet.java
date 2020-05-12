package com.tjetc.servlet;

import com.tjetc.service.UserService;
import com.tjetc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findByUsername")
public class FindByUsernameServlet extends HttpServlet {
    UserService us = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean flag = us.findbyu(username);
        if (flag){
            resp.getWriter().write("1");
        }else {
            resp.getWriter().write("0");
        }
    }
}
