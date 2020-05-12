package com.jd.servlet;

import com.jd.domain.Product;
import com.jd.service.ProductsService;
import com.jd.service.impl.ProductsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findProducts.do")
public class FindProductsServlet extends HttpServlet {
    ProductsService ps = new ProductsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        List<Product> products = ps.findAllByName(name);
        req.setAttribute("products",products);
        req.getRequestDispatcher("products.jsp").forward(req,resp);
    }
}
