package com.myshop.admin.setting.state;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myshop.common.entity.Country;
import com.myshop.common.entity.State;

public interface StateRepository extends JpaRepository<State, Integer> {
	
	public List<State> findByCountryOrderByNameAsc(Country country);
}
