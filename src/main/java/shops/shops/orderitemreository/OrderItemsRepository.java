package shops.shops.orderitemreository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shops.shops.orderitem.Orderitem;

@Repository
public interface OrderItemsRepository extends JpaRepository<Orderitem ,Integer> {
    List<Orderitem> findByOrdersId(int ordersid);
}

 