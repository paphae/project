package com.jd.servlet;

import com.jd.domain.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/add.do")
public class SessionCartServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Cart> map = (Map<String, Cart>) req.getSession().getAttribute("cart");
        if(map==null){
            Map<String,Cart> cartMap = new HashMap<>();
        }
    }
}
