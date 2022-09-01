package com.bean;

public class PaymentBean {
	
	String ccNum;
	String expDate;
	String email;
	Double amount;

	public String getCcNum() {
		return ccNum;
	}

	public void setCcNum(String ccNum) {
		this.ccNum = ccNum;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return email+" "+ccNum+" "+expDate+" "+amount;
	}



}
