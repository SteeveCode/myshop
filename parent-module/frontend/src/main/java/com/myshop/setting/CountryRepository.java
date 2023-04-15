package com.myshop.setting;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myshop.common.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
	public List<Country> findAllByOrderByNameAsc();
}
