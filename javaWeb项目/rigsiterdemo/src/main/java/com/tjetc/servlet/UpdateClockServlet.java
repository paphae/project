package com.tjetc.servlet;

import com.tjetc.service.ClockService;
import com.tjetc.service.impl.ClockServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jsp/clockUpdate.do")
public class UpdateClockServlet extends HttpServlet {
    ClockService cs = new ClockServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String uid = req.getParameter("uid");
        String info = req.getParameter("info");
        String ctime = req.getParameter("ctime");
        boolean b = cs.updateByid(id, uid, info, ctime);
        if (b){
            resp.sendRedirect(req.getContextPath()+"/jsp/findAllClockInfo.do");
        }else {
            resp.getWriter().write("fail");
        }
    }
}
