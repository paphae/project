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

@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String step = req.getParameter("step");
        String pid = req.getParameter("pid");
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("carts")){
                String value = URLDecoder.decode(cookie.getValue(), "utf-8");
                HashMap<String,String > map = JSON.parseObject(value, HashMap.class);
                map.replace(pid,String.valueOf(Integer.parseInt(map.get(pid))+Integer.parseInt(step)));
                String s = JSON.toJSONString(map,true);
                s = URLEncoder.encode(s, "utf-8");
                Cookie newCookie = new Cookie("carts", s);
                resp.addCookie(newCookie);
                Cart cart = new Cart(0,Integer.parseInt(pid),Integer.parseInt(map.get(pid)));
                String sj = JSON.toJSONString(cart);
                resp.getWriter().write(sj);
                break;
            }
        }

    }
}
