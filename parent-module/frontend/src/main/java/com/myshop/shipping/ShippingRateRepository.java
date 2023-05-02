package com.myshop.shipping;

import com.myshop.common.entity.Country;
import com.myshop.common.entity.ShippingRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Stack;

public interface ShippingRateRepository extends JpaRepository<ShippingRate, Integer>{
    public ShippingRate findByCountryAndState(Country country, String state);
}
