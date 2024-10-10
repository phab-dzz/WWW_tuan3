package vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.business;

import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.reposive.entities.ProductPrice;

public interface ProductPriceBeanRemote {
    ProductPrice  findProductPrice(int id);
}
