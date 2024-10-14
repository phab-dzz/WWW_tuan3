package vn.edu.iuh.fit.phandev.duongvanphan_ss2.frontend.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
//import jakarta.xml.ws.Response;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.reposive.entities.Product;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.reposive.entities.ProductPrice;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.frontend.DTO.ProductDTO;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.frontend.DTO.ProductPriceDTO;

import java.util.ArrayList;
import java.util.List;

public class ProductModels {


    private static final String GET_ALL_URL = "http://localhost:8080/DuongVanPhan_ss2-1.0-SNAPSHOT/api/products";
    private static final String ADD_URL = "http://localhost:8080/DuongVanPhan_ss2-1.0-SNAPSHOT/api/products/add";
    private static final String URL="http://localhost:8080/DuongVanPhan_ss2-1.0-SNAPSHOT/api";
    public static List<ProductDTO> getAllProducts() {
        List<ProductDTO> products = new ArrayList<>();  // Khởi tạo danh sách rỗng
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(GET_ALL_URL);
            products = target.request(MediaType.APPLICATION_JSON)  // Kiểm tra xem API trả về JSON hay XML
                    .get(new GenericType<List<ProductDTO>>() {});
        } catch (Exception e) {
            System.err.println("Error fetching products: " + e.getMessage());
            e.printStackTrace();
        }
        return products;
    }
    public static List<ProductDTO> getAll() {
        List<ProductDTO> productList = new ArrayList<>();
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target1 = client.target(GET_ALL_URL);
        String jsonProducts = target1.request("application/json")
                .get().readEntity(String.class);
        ObjectMapper mapper = new ObjectMapper();
        try {
            Product[] products = mapper.readValue(jsonProducts, Product[].class);

            for (Product product : products) {
                    ProductPrice productPrice = getProductPrice(product.getId());
                productList.add(
                        new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getImgPath(),productPrice)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }
    public static boolean addProduct(ProductDTO productDTO) {
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target(ADD_URL);

        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonProduct = mapper.writeValueAsString(productDTO);
            Response response = target.request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(jsonProduct, MediaType.APPLICATION_JSON));
            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                System.out.println("Product added successfully!");
                return true;
            } else {
                System.out.println("Failed to add product. Server response: " + ((jakarta.ws.rs.core.Response) response).getStatus());
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }}

        public static ProductPrice getProductPrice(int id) throws JsonProcessingException {
            Client client1 = ClientBuilder.newBuilder().build();
            WebTarget target1 = client1.target(URL).path("/products/price/" + id);
            String jsonProductPrice = target1.request("application/json")
                    .get().readEntity(String.class);
            ObjectMapper mapper1 = new ObjectMapper();
            mapper1.registerModule(new JavaTimeModule());
            return mapper1.readValue(jsonProductPrice, ProductPrice.class);
        }
            public static boolean deleteProduct(int productId) {
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target(GET_ALL_URL).path("/delete/" + productId);
        Response response = target.request().delete();

        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            System.out.println("Product deleted successfully!");
            return true;
        } else {
            System.out.println("Failed to delete product. Server response: " + response.getStatus());
            return false;
        }
    }
//public static List<ProductDTO> getAllProducts() {
//    List<ProductDTO> productList = new ArrayList<>();
//    Client client = ClientBuilder.newBuilder().build();
//    WebTarget target1 = client.target(BASEURI).path("/products");
//    String jsonProducts = target1.request("application/json")
//            .get().readEntity(String.class);
//    ObjectMapper mapper = new ObjectMapper();
//    try {
//        Prodcut[] products = mapper.readValue(jsonProducts, Product[].class);
//
//        for (Product product : products) {
//            ProductPrice productPrice = getProductPrice(product.getId());
//            productList.add(
//                    new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getImgPath(), productPrice.getValue())
//            );
//        }
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//    return productList;
//}
//}

    public static boolean updateProduct(ProductDTO productDTO) {
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target(GET_ALL_URL).path("/update"); // Thay thế UPDATE_PRODUCT_URL bằng URL API thực tế

        ObjectMapper mapper = new ObjectMapper();
        try {

            String jsonProduct = mapper.writeValueAsString(productDTO);


            Response response = target.request(MediaType.APPLICATION_JSON)
                    .put(Entity.entity(jsonProduct, MediaType.APPLICATION_JSON));
            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                System.out.println("Product updated successfully!");
                return true;
            } else {
                System.out.println("Failed to update product. Server response: " + response.getStatus());
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



}
