package shops.shops.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import shops.shops.orderitem.Orderitem;
import shops.shops.userentity.User;


@Entity
@Table(name="orders")
public class Orders {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private  int id ;
  @ManyToOne 
  @JoinColumn(name ="user_id")  
  private User user;
  @OneToMany(mappedBy = "orders",cascade = CascadeType.ALL)
  private List<Orderitem> Order_item = new ArrayList<>();
  @CreationTimestamp
  private LocalDateTime ordertime;
  private double total;

   public double getTotal() {
    return total;
  }
  public void setTotal(double total) {
    this.total = total;
  }
  
  public LocalDateTime getOrdertime() {
    return ordertime;
  }
  public void setOrdertime(LocalDateTime ordertime) {
    this.ordertime = ordertime;
  }
  public int getId() {
    return id;
  }
  public User getUser() {
    return user;
}
  public List<Orderitem> getOrder_item() {
    return Order_item;
  }
  public void setOrder_item(List<Orderitem> order_item) {
    Order_item = order_item;
  }
  public void setUser(User user) {
    this.user = user;
  }
  public void setId(int id) {
    this.id = id;
  }
  
    
}
