package com.myshop.setting;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.myshop.common.entity.Country;
import com.myshop.common.entity.State;

public interface StateRepository extends CrudRepository<State, Integer> {
	
	public List<State> findByCountryOrderByNameAsc(Country country);
}
