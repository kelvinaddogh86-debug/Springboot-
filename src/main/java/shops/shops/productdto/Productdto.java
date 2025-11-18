package shops.shops.productdto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class Productdto {

    @NotBlank(message = "product name is requard ")
    @Size(max = 20,message = "product name must be less than 20 letters")
    private String productname;
    @NotNull(message = "product price is requard")
    @Positive(message = "price must be greater than zero")
    private double price;
    @NotBlank(message = "product discription requard")
    @Size(max = 80 ,message = "product discription must be less than 80 letters")
    private String discription;
    private String product_image ;

    public Productdto(){}
    
    public Productdto (String productname,double price, String discription,String product_image){

        this.productname = productname;
        this.price= price;
        this.discription= discription;
        this.product_image = product_image;

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

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    
}
