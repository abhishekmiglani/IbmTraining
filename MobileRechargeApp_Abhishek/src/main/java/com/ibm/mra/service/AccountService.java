package com.ibm.mra.service;

import com.ibm.mra.bean.Account;

public interface AccountService {
	Account getAccountDetails(String mobileNo);

	int rechargeAccount(String mobileno, double rechargeAmount);
}