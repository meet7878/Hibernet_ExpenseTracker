package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.RoleBean;

@Repository
public interface RoleRepository extends CrudRepository<RoleBean, Integer> {

	List<RoleBean> findAll();
	
	RoleBean findByRoleName(String roleName); 
}
