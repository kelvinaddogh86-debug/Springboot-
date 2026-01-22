package shops.shops.orderitem;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import shops.shops.order.Orders;
import shops.shops.product.Products;
@Entity
public class Orderitem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "products_id")
    private Products products;
    @ManyToOne
    @JoinColumn(name="orders_id")
    private Orders orders;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Products getProducts() {
        return products;
    }
    public void setProducts(Products products) {
        this.products = products;
    }
    public Orders getOrder() {
        return orders;
    }
    public void setOrder(Orders order) {
        this.orders = order;
    }
    
    
}

