package vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.reposive.Responsity;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.reposive.entities.ProductPrice;

import java.util.List;
@Stateless
public class ProductPriceResponsity {
    @PersistenceContext(name = "JPA_MATIA")
    private EntityManager em;
    public List<ProductPrice> getAllPrice() {
        return em.createQuery("select p from ProductPrice p", ProductPrice.class).getResultList();
    }
    public ProductPrice findProductPrice(int id) {
        return em.find(ProductPrice.class, id);
    }

}
