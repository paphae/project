package com.jd.servlet;

import com.alibaba.fastjson.JSON;
import com.jd.dao.CategoryDao;
import com.jd.domain.Category;
import com.jd.service.CategoryService;
import com.jd.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findCategory.do")
public class FindCategoryServlet extends HttpServlet {
    CategoryService cs = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = cs.findAll();
        resp.setContentType("text/html;charset=UTF-8");
        String s = JSON.toJSONString(categories);
        resp.getWriter().write(s);
    }
}
