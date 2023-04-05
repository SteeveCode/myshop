package com.myshop.backend.admin.category;

import com.myshop.common.entity.Category;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
                @Query("SELECT c FROM Category c WHERE c.parent.id is NULL")
                public List<Category> findRootCategories(Sort sort);

                public Long countById(Integer id);

                public Category findByName(String name);

                public Category findByAlias(String alias);

                @Query("UPDATE Category c SET c.enabled = ?2 WHERE c.id = ?1")
                @Modifying
                public void updateEnabledStatus(Integer id, boolean enabled);
        }