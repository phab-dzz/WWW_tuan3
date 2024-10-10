package vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.business;

import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.reposive.entities.Product;

import java.util.List;

public interface ProductBeanRemote {
     boolean addProduct(Product product);

    List<Product> getAllProduct();
    Product getProductById(int id);
    boolean updateProduct(Product product);
    boolean deleteProductById(int id);

}
