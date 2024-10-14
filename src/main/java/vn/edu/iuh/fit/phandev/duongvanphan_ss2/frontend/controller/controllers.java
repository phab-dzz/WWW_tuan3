package vn.edu.iuh.fit.phandev.duongvanphan_ss2.frontend.controller;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.business.ProductBean;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.business.ProductBeanRemote;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.local.ProductBeanPro;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.local.ProductLocal;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.reposive.entities.Product;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.frontend.DTO.ProductDTO;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.frontend.models.ProductModels;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.List;
import java.nio.file.Paths;

@WebServlet(name = "ControlServlet", value = "/control-servlet")
public class controllers extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @EJB
    private ProductLocal productBean;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        List<ProductDTO> list=ProductModels.getAll();
        switch (action){
            case "addproduct":
            {
//                String fileName=null;
//                Part filePart = req.getPart("anh"); // "file" là tên của input trong form
//                if (filePart != null) {
//
//                 fileName  = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
//                }
                    String name=req.getParameter("name");
                String des=req.getParameter("description");
                ProductDTO p= new ProductDTO(name,des);
                boolean result=ProductModels.addProduct(p);
                if (result){
                    resp.getWriter().println("Product added");
                }
                else{
                    resp.getWriter().println("Product not added");
                }
                break;

            }case"updateproduct":{
                String name=req.getParameter("name");
                String des=req.getParameter("description");
                ProductDTO p= new ProductDTO(name,des);
                boolean result=ProductModels.updateProduct(p);

                if (result){
                    resp.getWriter().println("Product added");
                }
                else{
                    resp.getWriter().println("Product not added");
                }
                break;
            }


            default : {
                resp.sendError(400, "Get Action is invalid");
            }
        }
    }

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
               case"deleteproduct": {
                   String id = req.getParameter("id");
                   int Id = Integer.parseInt(id);
                   boolean re = ProductModels.deleteProduct(Id);

                   if (re) {
                       resp.getWriter().println("Product delete success");
                   } else {
                       resp.getWriter().println("Product delete failed");
                   }
                   break;


               } case"update":{
                   String id = req.getParameter("id");
                   ProductDTO p=new ProductDTO();
                   for(ProductDTO pro:list){
                       if (pro.getId()==Integer.parseInt(id)){
                           p=pro;
                           break;
                       }

                   }
                  req.setAttribute("product", p);
                   req.getRequestDispatcher("/pages/capnhatsanpham.jsp").forward(req, resp);
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
