package com.myshop.admin.customer;

<<<<<<< HEAD
import com.myshop.admin.paging.SearchRepository;
=======
>>>>>>> 19da961aa31f60b83f03d99d44cacda88bbd7256
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.myshop.common.entity.Customer;

<<<<<<< HEAD
public interface CustomerRepository extends SearchRepository<Customer, Integer> {
=======
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
>>>>>>> 19da961aa31f60b83f03d99d44cacda88bbd7256
	
	@Query("SELECT c FROM Customer c WHERE CONCAT(c.email, ' ', c.firstName, ' ', c.lastName, ' ', "
			+ "c.addressLine1, ' ', c.addressLine2, ' ', c.city, ' ', c.state, "
			+ "' ', c.postalCode, ' ', c.country.name) LIKE %?1%")
	public Page<Customer> findAll(String keyword, Pageable pageable);
	
	@Query("UPDATE Customer c SET c.enabled = ?2 WHERE c.id = ?1")
	@Modifying
	public void updateEnabledStatus(Integer id, boolean enabled);
	
	@Query("SELECT c FROM Customer c WHERE c.email = ?1")
	public Customer findByEmail(String email);
	
	public Long countById(Integer id);	
}
