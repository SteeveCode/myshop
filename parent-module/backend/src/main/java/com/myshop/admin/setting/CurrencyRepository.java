package com.myshop.admin.setting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.myshop.common.entity.Currency;

import java.util.List;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
    public List<Currency> findAllByOrderByNameAsc(); // Asc is used by Spring to sort in ascending order
}
