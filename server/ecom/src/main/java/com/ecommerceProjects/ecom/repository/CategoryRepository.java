package com.ecommerceProjects.ecom.repository;

import com.ecommerceProjects.ecom.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository extends JpaRepository<Category, Long> {
}
