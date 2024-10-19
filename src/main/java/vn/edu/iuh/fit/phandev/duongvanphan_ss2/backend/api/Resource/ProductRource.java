package vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.api.Resource;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.business.ProductBeanRemote;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.business.ProductPriceBeanRemote;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.reposive.entities.Product;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.reposive.entities.ProductPrice;

@Path("/products")
public class ProductRource {
    @EJB
    private ProductBeanRemote productBeanRemote;
    @EJB
    private ProductPriceBeanRemote productPriceBeanRemote;
    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public Response getAllProduct() {
        return  Response.ok(productBeanRemote.getAllProduct()).build();
    }
    @GET
    @Path("/{id}")
    public Response getProductById(@PathParam("id") int id) {
        Product product = productBeanRemote.getProductById(id);
        if (product == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(product).build();
    }
//    @POST
//    @Path("/add")
//    public Response addProduct() {
//        productBeanRemote.addProduct();
//        return Response.ok().build();
//    }
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct(Product product) {
        productBeanRemote.addProduct(product);
        return Response.ok().build();
    }
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProduct(Product product) {

//        if (productBeanRemote.getProductById(product.getId()) == null) {
//            return Response.status(Response.Status.NOT_FOUND).build(); // trả về 404 nếu không tìm thấy sản phẩm
//        }

        productBeanRemote.updateProduct(product); // Giả sử phương thức này cũng có thể sử dụng để cập nhật sản phẩm
        return Response.ok().build();
    }
    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProduct(@PathParam("id") int id) {
        if (productBeanRemote.getProductById(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if(productBeanRemote.deleteProductById(id))
        {
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();



    }
    @GET
    @Path("price/{id}")
    public Response getProductPrice(@PathParam("id") int id) {
        if(productPriceBeanRemote.findProductPrice(id)==null){
            return Response.status(Response.Status.NOT_FOUND).build();

        }
        return Response.ok(productPriceBeanRemote.findProductPrice(id)).build();
    }



}
