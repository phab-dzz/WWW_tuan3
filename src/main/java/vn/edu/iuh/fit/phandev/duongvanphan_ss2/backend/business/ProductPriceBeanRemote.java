package vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.business;

import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.reposive.entities.ProductPrice;

import java.util.List;

public interface ProductPriceBeanRemote {
    ProductPrice  findProductPrice(int id);
    List<ProductPrice> findAllProductPrices();
}
