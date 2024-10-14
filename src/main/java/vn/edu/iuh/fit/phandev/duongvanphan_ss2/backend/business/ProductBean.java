package vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.business;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.reposive.entities.Product;

import java.util.List;

@Stateless
public class ProductBean implements  ProductBeanRemote{
        @PersistenceContext(unitName = "JPA_MARIADB")
    private EntityManager entityManager;
//    public ProductBean(){
//        entityManager= Persistence.createEntityManagerFactory("JPA_MARIADB").createEntityManager();
//    }
    @Override
    public boolean addProduct(Product product) {
      try{

          entityManager.persist(product);

          return true;
      }
      catch(Exception e){
          e.printStackTrace();
      }
      return false;
    }

    @Override
    public List<Product> getAllProduct() {
        return entityManager.createQuery("select p from Product p", Product.class).getResultList();
    }

    @Override
    public Product getProductById(int id) {
        return entityManager.createQuery("select  p from Product  p where p.id = :id", Product.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public boolean updateProduct(Product product) {
        Product p= entityManager.find(Product.class, product.getId());
        if(p!=null){
            entityManager.merge(product);
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteProductById(int id) {
        Product p= entityManager.find(Product.class, id);
        if(p!=null){
            deleteProductPricesByProductId(id);
            entityManager.remove(p);
            return true;
        }
        return false;
    }
    private void deleteProductPricesByProductId(int productId) {
        // Sử dụng JPQL để xóa các bản ghi liên quan trong product_price
        entityManager.createQuery("DELETE FROM ProductPrice pp WHERE pp.product.id = :productId")
                .setParameter("productId", productId)
                .executeUpdate();
    }

//    public static void main(String[] args) {
//        ProductBean bean = new ProductBean();
//        List<Product> products = bean.getAllProduct();
//        for(Product product : products){
//            System.out.println(product);
//        }
//    }




}
