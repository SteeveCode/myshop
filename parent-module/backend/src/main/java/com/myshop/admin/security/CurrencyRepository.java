package com.myshop.admin.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.myshop.common.entity.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

}
