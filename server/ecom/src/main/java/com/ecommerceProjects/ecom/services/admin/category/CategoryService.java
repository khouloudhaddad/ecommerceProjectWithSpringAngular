package com.ecommerceProjects.ecom.services.admin.category;

import com.ecommerceProjects.ecom.dto.CategoryDto;
import com.ecommerceProjects.ecom.entity.Category;

public interface CategoryService {

    Category createCategory(CategoryDto categoryDto);
}
