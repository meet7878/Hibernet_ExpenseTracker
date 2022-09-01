package com.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.AccountBean;

@Repository
public interface AccountRepository extends CrudRepository<AccountBean, Integer> {
	@Query(value = "select * from account where user_id = :userId", nativeQuery = true)
	List<AccountBean> findByUser(Integer userId);
}