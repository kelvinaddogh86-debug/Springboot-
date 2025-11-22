package shops.shops.productservice;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import shops.shops.product.Products;
import shops.shops.productdto.Productdto;
import shops.shops.productinterface.Productinterface;
import shops.shops.productrepository.ProductRepository;


@Service
public class ProductSrivice implements Productinterface{
    

    @Autowired
    private ProductRepository productRepository;
    private final Path uploadPath = Paths.get("uploads");
     
    @Override
    public Productdto addproduct(Productdto productdto,MultipartFile imageFile){
        try {
            
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String fileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            Files.write(filePath, imageFile.getBytes());
            String imageUrl = "/uploads/" + fileName;
            productdto.setProduct_image(imageUrl);

            Products product = new Products();
            product.setProductname(productdto.getProductname());
            product.setPrice(productdto.getPrice());
            product.setDiscription(productdto.getDiscription());
            product.setProduct_image(productdto.getProduct_image());

              productRepository.save(product);

            return new Productdto(product.getProductname(),product.getPrice(),product.getDiscription(), product.getProduct_image());

        } catch (Exception e) {
            throw new RuntimeException("Failed to upload product image", e);
        }
      }

      private  Productdto convertTodto(Products products){
        Productdto productdto = new Productdto();
        productdto.setProductname(products.getProductname());
        productdto.setPrice(products.getPrice());
        productdto.setDiscription(products.getDiscription());
        productdto.setProduct_image(products.getProduct_image());
        return productdto;
       }
       @Override
      public List<Productdto> getAllproducts(){
       List < Products> products = productRepository.findAll();
        return products.stream().map(this::convertTodto).toList();
      }
    
      @Override
      public void delateproduct(String products){
        Products Product = productRepository.findProductByProductname(products)
        .orElseThrow(() -> new RuntimeException("product not found:"));
          productRepository.delete(Product);
      }
    
      @Override
      public Products getproduct(String productname){
       Products product = productRepository.findProductByProductname(productname)
       .orElseThrow(() -> new RuntimeException("product not found:"));
       return product;
        
      }

}

    
    


