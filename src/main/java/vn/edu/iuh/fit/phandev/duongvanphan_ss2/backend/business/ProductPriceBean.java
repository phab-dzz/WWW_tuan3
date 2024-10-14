package vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.business;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.reposive.entities.ProductPrice;

import java.util.List;
@Stateless
public class ProductPriceBean implements ProductPriceBeanRemote {
    @PersistenceContext(name="JPA_MARIA")
    private EntityManager em;
    @Override
    public ProductPrice findProductPrice( int id) {
        return  em.createQuery("select p from ProductPrice p where p.product.id= :id", ProductPrice.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public List<ProductPrice> findAllProductPrices() {
        return em.createQuery("select p from ProductPrice p", ProductPrice.class).getResultList();
    }
}
