package com.tjetc.servlet;

import com.tjetc.domain.Encrypted;
import com.tjetc.service.EncryptedService;
import com.tjetc.service.impl.EncryptedServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findPassword.do")
public class FindPasswordServlet extends HttpServlet {
    EncryptedService es = new EncryptedServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        if(username.equals("")){
            resp.sendRedirect(req.getContextPath()+"/username.jsp");
        }else {
            List<Encrypted> encrypteds = es.findByUsername(username);
            req.setAttribute("encrypteds",encrypteds);
            req.getRequestDispatcher("retrievePassword.jsp").forward(req,resp);
        }
    }
}
