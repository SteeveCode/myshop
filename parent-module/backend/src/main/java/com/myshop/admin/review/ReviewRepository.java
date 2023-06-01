package com.myshop.admin.review;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myshop.common.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
