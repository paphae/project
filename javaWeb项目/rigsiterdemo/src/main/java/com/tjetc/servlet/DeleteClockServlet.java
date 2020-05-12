package com.tjetc.servlet;

import com.tjetc.service.ClockService;
import com.tjetc.service.impl.ClockServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jsp/deleteClock.do")
public class DeleteClockServlet extends HttpServlet {
    ClockService cs = new ClockServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] idArrays = req.getParameterValues("idArray");
        boolean b = cs.deleteArray(idArrays);
        if (b){
            resp.sendRedirect(req.getContextPath()+"/jsp/findAllClockInfo.do");
        }else {
            resp.getWriter().write("fail");
        }
    }
}
