package com.myshop.admin.order;

import com.myshop.admin.paging.SearchRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import com.myshop.common.entity.Order;

import java.awt.print.Pageable;

public interface OrderRepository extends SearchRepository<Order, Integer> {

    @Query("SELECT o FROM Order o WHERE o.firstName LIKE %?1% OR"
            + " o.lastName LIKE %?1% OR o.phoneNumber LIKE %?1% OR"
            + " o.addressLine1 LIKE %?1% OR o.addressLine2 LIKE %?1% OR"
            + " o.postalCode LIKE %?1% OR o.city LIKE %?1% OR"
            + " o.state LIKE %?1% OR o.country LIKE %?1% OR"
            + " o.paymentMethod LIKE %?1% OR o.status LIKE %?1% OR"
            + " o.customer.firstName LIKE %?1% OR"
            + " o.customer.lastName LIKE %?1%")
    public Page<Order> findAll(String keyword, org.springframework.data.domain.Pageable pageable);
}