package com.tjetc.servlet;

import com.alibaba.fastjson.JSON;
import com.tjetc.domain.Emp;
import com.tjetc.domain.User;
import com.tjetc.service.EmpService;
import com.tjetc.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/jsp/findAll.do")
public class FindAllServlet extends HttpServlet {
    EmpService es = new EmpServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        User user = (User) request.getSession().getAttribute("user");
        List<Emp> all = new ArrayList<>();
        if (key==null||key.equals("")){
            all = es.findAll(user.getId());
        }else {
            all = es.findLike(key,user.getId());
        }
        request.setAttribute("emps",all);
        request.setAttribute("key",key);
        request.getRequestDispatcher("success.jsp").forward(request,response);
    }
}
