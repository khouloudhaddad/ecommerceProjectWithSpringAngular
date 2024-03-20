package com.ecommerceProjects.ecom.controller.admin;

import com.ecommerceProjects.ecom.dto.CategoryDto;
import com.ecommerceProjects.ecom.entity.Category;
import com.ecommerceProjects.ecom.services.admin.category.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminCategoryController {

    private final CategoryService categoryService;
    
    @RequestMapping("category")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto){
        Category category = categoryService.createCategory(categoryDto);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

}
