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
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/cookie.do")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        String number = req.getParameter("number");
        Cookie[] cookies = req.getCookies();
        HashMap<String , String> carts = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("carts")) {
                String value = URLDecoder.decode(cookie.getValue(), "utf-8");
                carts = JSON.parseObject(value, HashMap.class);
                if (carts.containsKey(pid)) {
                    carts.replace(pid, carts.get(pid), number);
                }else {
                    carts.put(pid, number);
                }
            } else {
                carts = new HashMap<>();
                carts.put(pid, number);
            }

            String s = JSON.toJSONString(carts,true);
            s = URLEncoder.encode(s, "utf-8");
            Cookie newCookie = new Cookie("carts", s);
            newCookie.setMaxAge(60 * 60 * 24 * 30);
            resp.addCookie(newCookie);
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        }
    }
}
