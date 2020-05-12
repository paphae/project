package com.jd.servlet;

import com.jd.domain.Category;
import com.jd.domain.Product;
import com.jd.service.CategoryService;
import com.jd.service.ProductService;
import com.jd.service.impl.CategoryServiceImpl;
import com.jd.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product.do")
public class ProductServlet extends HttpServlet {
    ProductService ps = new ProductServiceImpl();
    CategoryService cs = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Product product = ps.findById(Integer.parseInt(id));
        Category category = cs.findById(product.getCid());
        req.setAttribute("product",product);
        req.setAttribute("category",category);
        req.getRequestDispatcher("product.jsp").forward(req,resp);
    }
}
