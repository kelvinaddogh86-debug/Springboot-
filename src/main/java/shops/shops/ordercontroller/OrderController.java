package shops.shops.ordercontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shops.shops.order.Orders;
import shops.shops.orderitem.Orderitem;
import shops.shops.orderservice.OrderService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping()
public class OrderController {

    OrderService orderService;
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }
   @PostMapping("/addorder")
    public ResponseEntity<Orderitem>addorderiteam(
    @RequestParam int productid, 
    @RequestParam int orderid,
    @RequestParam int userid,
    @RequestParam int quantity){
    Orderitem saveOrderitem = orderService.addproduct(productid, orderid, userid, quantity);
    return ResponseEntity.ok(saveOrderitem);
    }  
     @GetMapping("/view/orders")
     public ResponseEntity<List<Orderitem>>showorders(@PathVariable int userid,int orderid){
       List< Orderitem> vieworders = orderService.view_Orders(userid, orderid);
       return  ResponseEntity.ok(vieworders);
     }

    @PostMapping("place/order")
    public ResponseEntity <Orders> placeOrder(@RequestParam int orderitemid , int orderid, int user ){
      Orders orderitems = orderService.placeOrder(orderitemid, orderid, user);
      return  ResponseEntity.ok(orderitems);
    }
  }
   
   
    

