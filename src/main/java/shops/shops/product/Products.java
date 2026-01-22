package shops.shops.product;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import shops.shops.orderitem.Orderitem;

@Entity
public class Products {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    
    @Column(name = "productname")
    private String productname;
    @Column(name = "price")
    private  double price ;
    @Column(name = "discription")
    private String discription;
    @Column(name = "product_image")
    private String product_image ;
    @OneToMany(mappedBy = "products",cascade = CascadeType.ALL)
    private List<Orderitem> order_item =  new ArrayList<>();
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getProductname() {
        return productname;
    }
    public void setProductname(String productname) {
        this.productname = productname;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getDiscription() {
        return discription;
    }
    public void setDiscription(String discription) {
        this.discription = discription;
    }
    public String getProduct_image() {
        return product_image;
    }
    public void setProduct_image(String product_image){
        this.product_image = product_image;
    }
          public List<Orderitem> getOrder_item() {
        return order_item;
    }
    public void setOrder_item(List<Orderitem> order_item) {
        this.order_item = order_item;

}

}