package shops.shops.userentity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;

    public User(){}

    public User ( String name , String email){
        this.name = name;
        this.email= email;
    }

  //  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  //  private List<Order> orders = new ArrayList<>();
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGmail() {
        return email;
    }
    public void setGmail(String gmail) {
        this.email = gmail;
    }
  //  public List<Order> getOrders() {
  //      return orders;
 //   }
  //  public void setOrders(List<Order> orders) {
   //     this.orders = orders;
   // }
    
}
