package com.myshop.admin.setting.country;

import java.util.List;


import com.myshop.common.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
	public List<Country> findAllByOrderByNameAsc();
}
