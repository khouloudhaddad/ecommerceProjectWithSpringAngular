package com.ecommerceProjects.ecom.services.admin.product;

import com.ecommerceProjects.ecom.dto.ProductDto;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto) throws IOException;
    List<ProductDto> getAllProducts();
}
