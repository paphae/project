package com.jd.servlet;

import com.alibaba.fastjson.JSON;
import com.jd.domain.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/cookieCart.do")
public class CookieCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Map carts = new HashMap<>();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("carts")) {
                String value = URLDecoder.decode(cookie.getValue(), "utf-8");
                carts = (Map) JSON.parse(value);
            }
        }
        req.setAttribute("carts", carts);
        req.getRequestDispatcher("cart.jsp").forward(req, resp);
    }
}
