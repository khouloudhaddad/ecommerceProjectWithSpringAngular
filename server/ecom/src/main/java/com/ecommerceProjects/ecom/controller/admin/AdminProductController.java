package com.ecommerceProjects.ecom.controller.admin;

import com.ecommerceProjects.ecom.dto.ProductDto;
import com.ecommerceProjects.ecom.services.admin.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminProductController {
<<<<<<< HEAD
<<<<<<< HEAD
    private final ProductService productService;
    
    @PostMapping("/product")
    public ResponseEntity<ProductDto> createProduct(@ModelAttribute ProductDto productDto) throws IOException 
    {
=======

    private final ProductService productService;
    
    @PostMapping("/product")
    public ResponseEntity<ProductDto> createProduct(@ModelAttribute ProductDto productDto) throws IOException {
>>>>>>> 260517517e59aa450fddc00a958890adf78a607e
        ProductDto productDto1 = productService.createProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto1);
    }
    
    @GetMapping("/products")
<<<<<<< HEAD
    public ResponseEntity<List<ProductDto>> getAllProducts()
    {
=======
    public ResponseEntity<List<ProductDto>> getAllProducts(){
>>>>>>> 260517517e59aa450fddc00a958890adf78a607e
        List<ProductDto> productDtos = productService.getAllProducts();
        return ResponseEntity.ok(productDtos);
    }
}
=======
>>>>>>> e4efdb51baa5b15b770e8050338f78fcb2dabf16
