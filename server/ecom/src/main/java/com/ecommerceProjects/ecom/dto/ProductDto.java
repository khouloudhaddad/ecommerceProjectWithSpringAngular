package com.ecommerceProjects.ecom.dto;

<<<<<<< HEAD
=======

>>>>>>> 260517517e59aa450fddc00a958890adf78a607e
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductDto {
<<<<<<< HEAD
    
=======

>>>>>>> 260517517e59aa450fddc00a958890adf78a607e
    private Long id;
    private String name;
    private Long price;
    private String description;
    private byte[] byteImg;
<<<<<<< HEAD
    private Long categoryId;
=======
    
    private Long categoryId;
    
>>>>>>> 260517517e59aa450fddc00a958890adf78a607e
    private MultipartFile img;
}
