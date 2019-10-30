package com.wallet.service;

import com.wallet.bean.Customer;

public interface CustomerCreatingServiceInt {
	public static final String NAMEPATTERN = "[A-Z][a-z]+";
	public static final String SAVING = "Saving";
	public static final String CURRENT = "Current";
	
	public String setAccountType(String type);
	public boolean validateCustomerName(String CustomerName);
	public boolean validateMobileNo(String mobileNo);
	public boolean validateAge(int age);
	public boolean validateAccount(String mobileNo);
	public boolean passToData(Customer customer);
	public boolean validatePassword(String mobile,String password);
}
