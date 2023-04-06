package com.myshop.backend.admin.product;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myshop.common.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
