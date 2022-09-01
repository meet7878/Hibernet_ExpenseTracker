package com.bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "role")
public class RoleBean {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Integer roleId;
	
	@Column(length = 15, nullable = false , unique = true)
	String roleName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "role")
	Set<UserBean> users;

	public Set<UserBean> getUsers() {
		return users;
	}

	public void setUsers(Set<UserBean> users) {
		this.users = users;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
