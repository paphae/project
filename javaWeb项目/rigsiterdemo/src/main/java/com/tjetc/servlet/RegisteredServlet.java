package com.tjetc.servlet;

import com.tjetc.service.UserService;
import com.tjetc.service.impl.UserServiceImpl;
import com.tjetc.domain.User;
import com.tjetc.util.MD5Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//没有这个类是添加servlet-api  jsp-api
@WebServlet("/registered.do")
public class RegisteredServlet extends HttpServlet {
    private UserService service =new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  username = request.getParameter("username");
        String  password = request.getParameter("password");
        User    user = new User(username, MD5Utils.getMD5(password));
        boolean flag = service.rigsiter(user);
        if(flag){
            response.getWriter().println("success");
        }else{
            response.getWriter().println("fail");
        }
    }
}
