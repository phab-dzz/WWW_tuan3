package vn.edu.iuh.fit.phandev.duongvanphan_ss2.frontend.controller;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.business.ProductBean;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.business.ProductBeanRemote;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.local.ProductBeanPro;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.local.ProductLocal;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.reposive.entities.Product;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.frontend.DTO.ProductDTO;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.frontend.models.ProductModels;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ControlServlet", value = "/control-servlet")
public class controllers extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @EJB
    private ProductLocal productBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
        List<ProductDTO> list=ProductModels.getAll();
        System.out.println(list.toString());
            String action = req.getParameter("action");
           switch (action){
               case"listproduct":{
                   req.setAttribute("products", list);
                   req.getRequestDispatcher("pages/danhsachsanpham.jsp").forward(req, resp);

               }

               default : {
                   resp.sendError(400, "Get Action is invalid");
               }
           }
//        PrintWriter out = resp.getWriter();
//        List<Product> Products=productBean.getAllProducts();
//        req.setAttribute("products", Products);
//        req.getRequestDispatcher("/products.jsp").forward(req, resp);
//        List<Product> Products= ProductModels.getAllProducts();
//        List<Product> l= productBean.getAllProduct();

//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>Products</title>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println("<h1>Products</h1>");
//        out.println("<ul>");
//        for (Product p : Products) {
//            out.println("<li>" + p.getName() + "</li>");
//
//        }
//        out.println("</ul>");
//        out.println("</body>");
//        out.println("</html>");


    }
}
