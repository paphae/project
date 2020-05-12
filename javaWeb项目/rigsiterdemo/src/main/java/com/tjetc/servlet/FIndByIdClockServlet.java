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

@WebServlet("/jsp/findByIdClock.do")
public class FIndByIdClockServlet extends HttpServlet {
    ClockService cs = new ClockServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Clock clock = cs.findById(id);
        req.setAttribute("clock",clock);
        req.getRequestDispatcher("/jsp/clockUpdate.jsp").forward(req,resp);
    }
}
