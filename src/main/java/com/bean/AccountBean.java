
package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "account")
public class AccountBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer accountId;
	String accountName;
	Float balance;
	String currency;
	// String accountType;
//	detail - upi cc dc 

	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	UserBean user = new UserBean();
	
	
	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}
	
	

}

