package vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.business;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.reposive.entities.ProductPrice;

public class ProductPriceBean implements ProductPriceBeanRemote {
    @PersistenceContext(name="JPA_MARIA")
    private EntityManager em;
    @Override
    public ProductPrice findProductPrice( int id) {
        return  em.createQuery("select p from ProductPrice p where p.id= :id", ProductPrice.class)
                .setParameter("id", id).setMaxResults(1).getSingleResult();
    }
}
