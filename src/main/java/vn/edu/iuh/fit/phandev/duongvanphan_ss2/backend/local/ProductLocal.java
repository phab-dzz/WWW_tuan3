package vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.local;

import jakarta.ejb.Local;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.business.ProductPriceBean;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.reposive.entities.Product;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.reposive.entities.ProductPrice;

import java.util.List;

@Local
public interface ProductLocal {

    public List<Product> getAllProducts();
    public Product findProduct(int id);
    public boolean addProduct(Product product);
    public boolean updateProduct(Product product);
    public boolean deleteProduct(int id);
    public ProductPrice getProductPrice(int id);
}
