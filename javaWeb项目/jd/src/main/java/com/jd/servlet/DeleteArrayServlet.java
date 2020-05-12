package com.jd.servlet;

import com.alibaba.fastjson.JSON;
import com.jd.domain.Cart;
import com.jd.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/deleteArray.do")
public class DeleteArrayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] pids = req.getParameterValues("pids");
        if (pids == null || pids.length==0){
            resp.sendRedirect("cookieCart.do");
        }
        Cookie[] cookies = req.getCookies();
        Map<String, Object> carts = new HashMap<>();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("carts")) {
                String value = URLDecoder.decode(cookie.getValue(), "utf-8");
                carts = (Map) JSON.parse(value);
            }
        }
        if (pids != null) {
            for (String pid : pids) {
                carts.remove(pid);
            }
        }
        String s = JSON.toJSONString(carts,true);
        s = URLEncoder.encode(s, "utf-8");
        Cookie newCookie = new Cookie("carts", s);
        newCookie.setMaxAge(60 * 60 * 24 * 30);
        resp.addCookie(newCookie);
        resp.sendRedirect("cookieCart.do");
    }
}
