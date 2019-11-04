package com.ibm.mra.dao;

import com.ibm.mra.bean.Account;

public interface AccountDao {
	Account getAccountDetails(String mobileNo);
	int rechargeAccount(String mobileNo,double rechargeAmount);
}
