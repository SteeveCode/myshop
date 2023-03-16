package com.myshop.backend.admin.user;

import com.myshop.common.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



public interface RoleRepository extends JpaRepository<Role, Integer> {

}