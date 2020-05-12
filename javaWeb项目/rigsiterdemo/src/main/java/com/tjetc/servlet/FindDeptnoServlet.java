package com.tjetc.servlet;

import com.alibaba.fastjson.JSON;
import com.tjetc.domain.Dept;
import com.tjetc.service.DeptService;
import com.tjetc.service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/jsp/findDeptno.do")
public class FindDeptnoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DeptService ds = new DeptServiceImpl();
        List<Dept> depts = ds.findAll();
        String strjson = JSON.toJSONString(depts);
        resp.getWriter().write(strjson);
    }
}
