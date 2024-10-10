package vn.edu.iuh.fit.phandev.duongvanphan_ss2.frontend.controller;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.business.ProductBeanRemote;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.reposive.entities.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ControlServlet", value = "/servlet")
public class ProductServlet extends HttpServlet {
    @EJB
    private ProductBeanRemote productBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Call the test() method or directly list all products
        List<Product> products = productBean.getAllProduct();

        out.println("<html><body>");
        out.println("<h1>Product List</h1>");
        out.println("<ul>");
        for (Product product : products) {
            out.println("<li>" + product.getName() + ": " + product.getDescription() + "</li>");
        }
        out.println("</ul>");
        out.println("</body></html>");
    }
}
