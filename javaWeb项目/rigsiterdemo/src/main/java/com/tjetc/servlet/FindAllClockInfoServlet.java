package com.tjetc.servlet;

import com.tjetc.domain.Clock;
import com.tjetc.service.ClockService;
import com.tjetc.service.impl.ClockServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/jsp/findAllClockInfo.do")
public class FindAllClockInfoServlet extends HttpServlet {
    ClockService cs = new ClockServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Clock> all = cs.findAll();
        req.setAttribute("all",all);
        req.getRequestDispatcher("clockInfo.jsp").forward(req,resp);
    }
}
