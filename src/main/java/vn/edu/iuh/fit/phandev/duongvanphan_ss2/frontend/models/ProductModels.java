package vn.edu.iuh.fit.phandev.duongvanphan_ss2.frontend.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.xml.ws.Response;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.reposive.entities.Product;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.frontend.DTO.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class ProductModels {

//    private final String ADD_URL = "http://localhost:8080/duongvanphan_ss2/api/products";
    private static final String GET_ALL_URL = "http://localhost:8080/DuongVanPhan_ss2-1.0-SNAPSHOT/api/products";

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

                productList.add(
                        new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getImgPath())
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }


//    public boolean addProduct(Product product) {
//        try (Client client = ClientBuilder.newClient()) {
//            WebTarget target = client.target(GET_ALL_URL);
//            target.request(MediaType.APPLICATION_XML).post(Entity.entity(product, MediaType.APPLICATION_XML));
////            target = target.queryParam("name", product.getName());
////            target = target.queryParam("description", product.getDescription());
//
//        }}
//
//
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
//
//    public static ProductPrice getProductPrice(long id) throws JsonProcessingException {
//        Client client = ClientBuilder.newBuilder().build();
//        WebTarget target = client.target(BASEURI).path("/products/price/" + id);
//        String jsonProductPrice = target.request("application/json")
//                .get().readEntity(String.class);
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.registerModule(new JavaTimeModule());
//        return mapper.readValue(jsonProductPrice, ProductPrice.class);
//    }
//public static boolean addProduct(ProductDTO productDTO) {
//    Client client = ClientBuilder.newBuilder().build();
//    WebTarget target = client.target(ADD_PRODUCT_URL); // Thay thế ADD_PRODUCT_URL bằng URL API thực tế
//
//    ObjectMapper mapper = new ObjectMapper();
//    try {
//        // Chuyển ProductDTO thành chuỗi JSON
//        String jsonProduct = mapper.writeValueAsString(productDTO);
//
//        // Gửi yêu cầu POST với chuỗi JSON
//        Response response = target.request(MediaType.APPLICATION_JSON)
//                .post(Entity.entity(jsonProduct, MediaType.APPLICATION_JSON));
//
//        // Kiểm tra phản hồi
//        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
//            System.out.println("Product added successfully!");
//            return true;
//        } else {
//            System.out.println("Failed to add product. Server response: " + response.getStatus());
//            return false;
//        }
//    } catch (Exception e) {
//        e.printStackTrace();
//        return false;
//    }
//}
//    public static boolean deleteProduct(int productId) {
//        Client client = ClientBuilder.newBuilder().build();
//        WebTarget target = client.target(DELETE_PRODUCT_URL) // Thay thế DELETE_PRODUCT_URL bằng URL API thực tế
//                .path(String.valueOf(productId)); // Thêm ID sản phẩm vào URL
//
//        // Gửi yêu cầu DELETE
//        Response response = target.request().delete();
//
//        // Kiểm tra phản hồi
//        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
//            System.out.println("Product deleted successfully!");
//            return true;
//        } else {
//            System.out.println("Failed to delete product. Server response: " + response.getStatus());
//            return false;
//        }
//    }
//    public static boolean updateProduct(ProductDTO productDTO) {
//        Client client = ClientBuilder.newBuilder().build();
//        WebTarget target = client.target(UPDATE_PRODUCT_URL); // Thay thế UPDATE_PRODUCT_URL bằng URL API thực tế
//
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            // Chuyển ProductDTO thành chuỗi JSON
//            String jsonProduct = mapper.writeValueAsString(productDTO);
//
//            // Gửi yêu cầu PUT với chuỗi JSON
//            Response response = target.request(MediaType.APPLICATION_JSON)
//                    .put(Entity.entity(jsonProduct, MediaType.APPLICATION_JSON));
//
//            // Kiểm tra phản hồi
//            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
//                System.out.println("Product updated successfully!");
//                return true;
//            } else {
//                System.out.println("Failed to update product. Server response: " + response.getStatus());
//                return false;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }



}
