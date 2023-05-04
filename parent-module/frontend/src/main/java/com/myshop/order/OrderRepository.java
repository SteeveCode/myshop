package com.myshop.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myshop.common.entity.order.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
