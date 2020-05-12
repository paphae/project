package com.tjetc.servlet;

import com.tjetc.service.ClockService;
import com.tjetc.service.impl.ClockServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jsp/clock.do")
public class ClockServlet extends HttpServlet {
    ClockService cs = new ClockServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String info = req.getParameter("info");
        String time = req.getParameter("time");
        boolean insert = cs.insert(id, info, time);
        if (insert){
            resp.getWriter().write("success");
        }else {
            resp.getWriter().write("fail");
        }
    }
}
