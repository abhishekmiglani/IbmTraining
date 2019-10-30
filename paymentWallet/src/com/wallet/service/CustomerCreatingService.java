package com.wallet.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.wallet.bean.Customer;
import com.wallet.dao.WalletData;
import com.wallet.dao.WalletDataInt;

public class CustomerCreatingService implements CustomerCreatingServiceInt {
	WalletDataInt wd = null;

	public CustomerCreatingService(Connection connection) {
		try {
			wd = new WalletData(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("There is some issue with Data layer");
		}
	}

	public String setAccountType(String type) {
		if (type.equalsIgnoreCase("Current"))
			return CURRENT;
		else
			return SAVING;
	}

	public boolean validateCustomerName(String customerName) {
		if (customerName.matches(NAMEPATTERN))
			return true;
		else
			return false;
	}

	public boolean validateMobileNo(String mobileNo) {
		if (mobileNo.length() > 10 || mobileNo.length() < 10)
			return false;
		else
			return true;
	}

	public boolean validateAge(int age) {
		if (age >= 18)
			return true;
		else
			return false;
	}

	public boolean validateAccount(String mobileNo) {
		return wd.validatingAccount(mobileNo);
	}

	public boolean passToData(Customer customer) {
		try {
			if (wd.storeInDatabase(customer))
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("line no 61 file NewCustomer");
		}
		return false;
	}

	public boolean validatePassword(String mobileNo, String password) {
		// TODO Auto-generated method stub
		return wd.validatePassword(mobileNo,password);
	}

}
