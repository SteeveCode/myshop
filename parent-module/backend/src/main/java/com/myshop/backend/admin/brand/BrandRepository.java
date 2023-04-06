package com.myshop.backend.admin.brand;

import com.myshop.common.entity.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface BrandRepository extends JpaRepository<Brand, Integer> {
        public Long countById(Integer id);

        public Brand findByName(String name);

        @Query("SELECT b FROM Brand b WHERE b.name LIKE %?1%")
        public Page<Brand> findAll(String keyword, Pageable pageable);


}
