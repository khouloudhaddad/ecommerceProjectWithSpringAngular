package com.ecommerceProjects.ecom.services.admin.product;

import com.ecommerceProjects.ecom.dto.ProductDto;
import com.ecommerceProjects.ecom.entity.Category;
import com.ecommerceProjects.ecom.entity.Product;
import com.ecommerceProjects.ecom.repository.CategoryRepository;
import com.ecommerceProjects.ecom.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    
<<<<<<< HEAD
<<<<<<< HEAD
    public ProductDto createProduct(ProductDto productDto) throws IOException
    {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
=======
    public ProductDto createProduct(ProductDto productDto) throws IOException {
        Product product = new Product();
        product.setName(product.getName());
        product.setDescription(product.getDescription());
        product.setPrice(product.getPrice());
>>>>>>> 260517517e59aa450fddc00a958890adf78a607e
        product.setImg(productDto.getImg().getBytes());

        Category category = categoryRepository.findById(productDto.getCategoryId()).orElseThrow();
        
        product.setCategory(category);
        
        return productRepository.save(product).getDto();
    }
    
<<<<<<< HEAD
    public List<ProductDto> getAllProducts()
    {
=======
    public List<ProductDto> getAllProducts(){
>>>>>>> 260517517e59aa450fddc00a958890adf78a607e
        List<Product> products = productRepository.findAll();
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }
}
=======

>>>>>>> e4efdb51baa5b15b770e8050338f78fcb2dabf16
