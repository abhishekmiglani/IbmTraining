package com.wallet.bean;

public class Customer {

	private final String accountNo, walletId, mobileNo;
	private String customerName, accountType;
	private double accountBalance = 0.00, walletBalance = 0.00;
	private int age;
	private String password;

	public Customer(String customerName, String accountType , String mobileNo , int age, String password) {
		this.accountNo = mobileNo;
		this.walletId = "w"+mobileNo;
		this.customerName = customerName;
		this.accountType = accountType;
		this.mobileNo = mobileNo;
		this.age = age;
		this.password = password;
	}
	
	

	public Customer(String accountNo, String walletId, String mobileNo, String customerName, String accountType,
			double accountBalance, double walletBalance, int age) {
		this.accountNo = accountNo;
		this.walletId = walletId;
		this.mobileNo = mobileNo;
		this.customerName = customerName;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.walletBalance = walletBalance;
		this.age = age;
	}



	public String getMobileNo() {
		return mobileNo;
	}

	public int getAge() {
		return age;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Double getWalletBalance() {
		return walletBalance;
	}

	public void setWalletBalance(Double walletBalance) {
		this.walletBalance = walletBalance;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public String getWalletId() {
		return walletId;
	}

	public String getAccountType() {
		return accountType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
