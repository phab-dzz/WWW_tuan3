package vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.api.Resource;

import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.business.ProductPriceBeanRemote;

@Path("/ProductPrice")
public class ProductPriceResouce {
    @EJB
    private ProductPriceBeanRemote productPriceBean;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductPrice() {
        return Response.ok(productPriceBean.findAllProductPrices()).build();
    }

}
