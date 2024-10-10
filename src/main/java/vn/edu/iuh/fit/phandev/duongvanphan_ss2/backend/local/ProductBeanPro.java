package vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.local;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.reposive.Responsity.ProductPriceResponsity;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.reposive.Responsity.ProductResponsity;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.reposive.entities.Product;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.reposive.entities.ProductPrice;

import java.util.List;

@Stateless
public class ProductBeanPro implements ProductLocal {
    @Inject
    private ProductResponsity productBean;
    @Inject
    private ProductPriceResponsity productPriceBean;

    @Override
    public List<Product> getAllProducts() {
        return productBean.getAllProducts();
    }

    @Override
    public Product findProduct(int id) {
        return productBean.getProductById(id);
    }

    @Override
    public boolean addProduct(Product product) {
        return productBean.addProduct(product);
    }

    @Override
    public boolean updateProduct(Product product) {
        return productBean.updateProduct(product);
    }

    @Override
    public boolean deleteProduct(int id) {
        Product product = productBean.getProductById(id);
        if (product != null) {
            return productBean.deleteProduct(id);
        }
        return false;

    }

    @Override
    public ProductPrice getProductPrice(int id) {
        return productPriceBean.findProductPrice(id);
    }
}
