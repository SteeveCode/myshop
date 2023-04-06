package com.myshop.backend.admin.brand;

import com.myshop.common.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface BrandRepository extends JpaRepository<Brand, Integer> {
        public Long countById(Integer id);

        public Brand findByName(String name);


}
