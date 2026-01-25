package shops.shops.orderservice;

import java.util.List;
import org.springframework.stereotype.Service;
import shops.shops.order.Orders;
import shops.shops.orderitem.Orderitem;
import shops.shops.orderitemreository.OrderItemsRepository;
import shops.shops.orderrepository.OrderRepoaitory;
import shops.shops.product.Products;
import shops.shops.productrepository.ProductRepository;
import shops.shops.userentity.User;
import shops.shops.userrepository.UserRepository;

@Service 
public class OrderService {

    private ProductRepository productRepository;
    private OrderItemsRepository orderitemstRepository;
    private OrderRepoaitory orderRepoaitory;
    private UserRepository userRepository;

    public OrderService(ProductRepository productRepository
        ,OrderItemsRepository orderitemsRepository
        , OrderRepoaitory orderRepoaitory
         ,UserRepository userRepository){

        this.productRepository = productRepository;
        this.orderitemstRepository = orderitemsRepository;
        this.userRepository = userRepository;
    }

    public  Orderitem  addproduct(int productid, int orderid,int userid, int quantity){
        Products product = productRepository.findById(productid)
        .orElseThrow(() -> new RuntimeException("product not found:"));   
    
        Orders oder = orderRepoaitory.findById(orderid)
        .orElseThrow(() -> new RuntimeException("product not found:"));

        User user = userRepository.findById(userid)
         .orElseThrow(() -> new RuntimeException("user not found:"));
            
         if(oder.getUser().getId()!=(user.getId())){
              throw new RuntimeException("Order does not belong to this user");
         }
        Orderitem orderitem = new Orderitem();
        orderitem.setProducts(product);
        orderitem.setOrder(oder);
        orderitem.setQuantity(quantity);

        return  orderitemstRepository.save(orderitem);         
    }

    public List<Orderitem> view_Orders(int userid , int orderid){
        User  user = userRepository.findById(userid)
        .orElseThrow(() -> new RuntimeException("user not found:"));

        Orders  orders = orderRepoaitory.findById(orderid)
        .orElseThrow(() -> new RuntimeException("user not found:"));

        if(orders.getUser().getId()!=(user.getId())){
            throw new RuntimeException("not permited");
        }
        return  orderitemstRepository.findByOrdersId(orderid);   
    }
    
    public Orders placeOrder(int orderiteamsid, int orderid, int userid){
    List <Orderitem> items = orderitemstRepository.findByOrdersId(orderiteamsid);
     Orders orders = orderRepoaitory.findById(orderid)
     .orElseThrow(() -> new RuntimeException("order not found:"));
     User user = userRepository.findById(userid)
     .orElseThrow(() -> new RuntimeException("user not found:"));
     if(orders.getUser().getId()!=(user.getId())){
        throw new RuntimeException("not permited");
     }
    double total = 0;
    for(Orderitem item : items){
    total += item.getProducts().getPrice() * item.getQuantity();
    }
    orders.setTotal(total);
      return orderRepoaitory.save(orders);
    }


}













