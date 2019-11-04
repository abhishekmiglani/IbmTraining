package com.ibm.mra.bean;

public class Account {
	@Override
	public String toString() {
		return accountBalance.toString();
	}

	private String accountType;
	private String customerName;
	private Double accountBalance;

	public Account(String accountType, String customerName, Double accountBalance) {
		this.accountType = accountType;
		this.customerName = customerName;
		this.accountBalance = accountBalance;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

}
