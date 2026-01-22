package shops.shops.orderrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shops.shops.order.Orders;

@Repository
public interface OrderRepoaitory  extends JpaRepository<Orders,Integer> {
    
}
