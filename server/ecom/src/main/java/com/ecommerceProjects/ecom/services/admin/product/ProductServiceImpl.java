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
    

