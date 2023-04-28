package com.myshop.admin.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.myshop.common.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
