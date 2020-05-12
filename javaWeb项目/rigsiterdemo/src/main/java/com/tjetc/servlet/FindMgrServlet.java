package com.tjetc.servlet;

import com.alibaba.fastjson.JSON;
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

@WebServlet("/jsp/findMgr.do")
public class FindMgrServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmpService es = new EmpServiceImpl();
        List<Emp> all = es.findAll(1);
        String strJson = JSON.toJSONString(all);
        response.getWriter().write(strJson);
    }
}
