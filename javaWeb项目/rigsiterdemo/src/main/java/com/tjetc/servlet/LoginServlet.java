package com.tjetc.servlet;

import com.tjetc.domain.User;
import com.tjetc.service.UserService;
import com.tjetc.service.impl.UserServiceImpl;
import com.tjetc.util.MD5Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
    private UserService service =new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  username = request.getParameter("username");
        String  password = request.getParameter("password");
        password = MD5Utils.getMD5(password);
        String code = request.getParameter("code");
        String realCode = (String)request.getSession().getAttribute("code");
        if(code.equalsIgnoreCase(realCode)) {
            User flag = service.login(username, password);

            if (flag!=null) {
                // 跳转有俩种 一种转发 （服务器跳转）request   一种重定向（客户端跳转）response
                //转发服务器跳转
                request.getSession().setAttribute("user", flag);
                response.sendRedirect(request.getContextPath()+"/jsp/findAll.do");
            } else {
                response.sendRedirect("login.jsp");
            }
        }else {
            response.sendRedirect("login.jsp");
        }
    }
}
