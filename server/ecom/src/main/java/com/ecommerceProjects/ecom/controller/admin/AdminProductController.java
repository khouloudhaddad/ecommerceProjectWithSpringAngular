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

    private final ProductService productService;
    
    @PostMapping("/product")
    public ResponseEntity<ProductDto> createProduct(@ModelAttribute ProductDto productDto) throws IOException {
        ProductDto productDto1 = productService.createProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto1);
    }
    
    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> productDtos = productService.getAllProducts();
        return ResponseEntity.ok(productDtos);
    }
}
