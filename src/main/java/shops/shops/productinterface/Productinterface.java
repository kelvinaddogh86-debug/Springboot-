package shops.shops.productinterface;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import shops.shops.productdto.Productdto;

public interface Productinterface {

    Productdto addproduct(Productdto productdto, MultipartFile imageFile);
     List <Productdto> getAllproducts();

}
