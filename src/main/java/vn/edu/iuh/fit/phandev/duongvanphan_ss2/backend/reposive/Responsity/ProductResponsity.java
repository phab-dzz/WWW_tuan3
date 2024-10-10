package vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.reposive.Responsity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.reposive.entities.Product;

import java.util.List;

public class ProductResponsity {
    @PersistenceContext(name = "JPA_MARIA")
    private EntityManager em;
    public  boolean addProduct(Product product) {
        try{
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  false;
    }
    public  boolean updateProduct(Product product) {
        try{
            em.getTransaction().begin();
            em.merge(product);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {

            e.printStackTrace();
        }
        return  false;
    }
    public  boolean deleteProduct(int id) {
        try{
            Product product = em.find(Product.class, id);
            em.getTransaction().begin();
            em.remove(product);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  false;
    }
    public Product getProductById(int id) {
        return em.find(Product.class, id);
    }
    public List<Product> getAllProducts() {
        return em.createQuery("select  p from Product p", Product.class).getResultList();
    }

}
