package com.ecommerceProjects.ecom.services.admin.category;

import com.ecommerceProjects.ecom.dto.CategoryDto;
import com.ecommerceProjects.ecom.entity.Category;

import java.util.List;

public interface CategoryService {

    Category createCategory(CategoryDto categoryDto);
    List<Category> getAllCategories();
}
