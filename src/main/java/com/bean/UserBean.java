package com.bean;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Table(name = "users")
@Data
public class UserBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer userId;
	String firstName;
	String email;
	String password;
	String gender;
	
	@ManyToOne
	@JoinColumn(name = "roleId", nullable = false)
	RoleBean role;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	Set<AccountBean> accounts = new HashSet<>();
	
	String authToken;
	
	
	
	
}
