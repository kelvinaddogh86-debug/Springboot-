package shops.shops.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import shops.shops.productdto.Productdto;
import shops.shops.productservice.ProductSrivice;
import shops.shops.userentity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("/api")
@RestController
public class Usercontroller {
     @Autowired
     private ProductSrivice productSrivice;

    @GetMapping("/userinfo")
    public ResponseEntity<User> getuseinfo(@AuthenticationPrincipal OAuth2User oAuth2User){
     String name = oAuth2User.getAttribute("name");
     String email = oAuth2User.getAttribute("email");
     User user = new User(name,email);

     return ResponseEntity.ok(user);
    }
    
    @PostMapping(path = "/admin addproduct")
    public ResponseEntity<Productdto> addproduct( @Valid 
     @RequestPart("products") Productdto productdto,
     @RequestPart("file") MultipartFile file){
       productSrivice.addproduct(productdto,file);
     return ResponseEntity.ok().build();
    
}
    
}