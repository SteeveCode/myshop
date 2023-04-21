package com.myshop.setting;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myshop.common.entity.Country;
import org.springframework.data.jpa.repository.Query;

public interface CountryRepository extends JpaRepository<Country, Integer> {
	public List<Country> findAllByOrderByNameAsc();

	@Query("SELECT c FROM Country c WHERE c.code = ?1")
	public Country findByCode(String code);
}
