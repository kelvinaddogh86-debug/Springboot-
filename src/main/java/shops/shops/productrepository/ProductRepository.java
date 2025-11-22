package shops.shops.productrepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import shops.shops.product.Products;

public interface ProductRepository extends JpaRepository<Products,Integer>{
    Optional <Products> findProductByProductname(String productname);

}
