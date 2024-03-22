package com.ecommerceProjects.ecom.controller.admin;

import com.ecommerceProjects.ecom.dto.CategoryDto;
import com.ecommerceProjects.ecom.entity.Category;
import com.ecommerceProjects.ecom.services.admin.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminCategoryController {

    private final CategoryService categoryService;
    
    @PostMapping("category")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto){
        Category category = categoryService.createCategory(categoryDto);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }
    
    @GetMapping("categories")
    public ResponseEntity<List<Category>> getAllCategories()
    {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

}
