package shops.shops.usercontroller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
/* 
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import shops.shops.emailsender.Emailsender;
import shops.shops.product.Products;
import shops.shops.productdto.Productdto;
import shops.shops.productservice.ProductSrivice;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping()
public class Usercontroller {
      
     private Emailsender emailsender;
     private ProductSrivice productSrivice;

     public Usercontroller(Emailsender emailsender,ProductSrivice productSrivice){
      this.emailsender = emailsender;
      this.productSrivice = productSrivice;
     }

   /*  @GetMapping("/userinfo")
    public ResponseEntity<User> getuseinfo(@AuthenticationPrincipal OAuth2User oAuth2User){
     String name = oAuth2User.getAttribute("name");
     String email = oAuth2User.getAttribute("email");
     User user = new User(name,email);
      emailsender.sendemail(user);

     return ResponseEntity.ok(user);
    }
     */
    
    @GetMapping("/user/home")
    public String homepage(){
      return"this the home page";
    }
      
    @PostMapping(path ="/admin/addproduct", consumes  = MediaType.MULTIPART_FORM_DATA_VALUE )
    public ResponseEntity<Productdto> addproduct( 
     @RequestPart("product") @Valid Productdto productdto,
     @RequestPart("file") MultipartFile file){ 
        productSrivice.addproduct(productdto,file);
     return ResponseEntity.ok().build();
    
   }
    @GetMapping("/user/getall")
    public ResponseEntity <List< Productdto>>getallproduct(){
    List <Productdto> productdtos = productSrivice.getAllproducts();
    return ResponseEntity.ok(productdtos);
  
  }
    @DeleteMapping("/admin/deletproduct")
    public ResponseEntity<Void> delateproduct(@RequestParam String productname){
        productSrivice.delateproduct(productname);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/product/user")
    public ResponseEntity< Products> findproduct(@RequestParam String productname){
        return ResponseEntity.ok(productSrivice.getproduct(productname));
    }

    @GetMapping("/user/product/key")
   public ResponseEntity<List<Products>> searchkeyword(@RequestPart String keyword){
    return ResponseEntity.ok(productSrivice.searchbykey(keyword));
    }

    
 }