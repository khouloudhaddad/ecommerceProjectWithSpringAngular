package com.ecommerceProjects.ecom.services.admin.category;

import com.ecommerceProjects.ecom.dto.CategoryDto;
import com.ecommerceProjects.ecom.entity.Category;
import com.ecommerceProjects.ecom.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    public final CategoryRepository categoryRepository;
    public Category createCategory(CategoryDto categoryDto){
    
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        
        return categoryRepository.save(category);
    }
    
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
}
