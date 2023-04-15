package com.myshop.admin.setting.country;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.myshop.common.entity.Country;

@RestController
public class CountryRestController {

	@Autowired private CountryRepository repo;
	
	@GetMapping("/countries/list")
	public List<Country> listAll() {
		return repo.findAllByOrderByNameAsc();
	}
	
	@PostMapping("/countries/save")
	public String save(@RequestBody Country country) {
		Country savedCountry = repo.save(country);
		return String.valueOf(savedCountry.getId());
	}
	
	@DeleteMapping("/countries/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}
}
