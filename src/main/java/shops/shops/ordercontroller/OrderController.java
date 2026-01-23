package shops.shops.ordercontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shops.shops.order.Orders;
import shops.shops.orderitem.Orderitem;
import shops.shops.orderservice.OrderService;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping()
public class OrderController {

    OrderService orderService;
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

  @PostMapping("/addorder")
  public ResponseEntity<Orderitem>addorderiteam(@RequestBody Orderitem orderitemid ){
        Orderitem orderitem = orderService.addproduct(orderitemid);
     
  }
   
   
    
}
