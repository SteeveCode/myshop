package com.myshop.setting;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myshop.common.entity.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

}
