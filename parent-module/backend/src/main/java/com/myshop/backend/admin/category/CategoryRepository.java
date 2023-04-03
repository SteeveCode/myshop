package com.myshop.backend.admin.category;

import com.myshop.common.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
        @Query("SELECT c FROM Category c WHERE c.parent.id is NULL")
        public List<Category> findRootCategories();

}
