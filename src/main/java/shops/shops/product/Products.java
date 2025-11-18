package shops.shops.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Products {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    private String productname;
    private  double price ;
    private String discription;
    private String product_image ;
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
          

}

