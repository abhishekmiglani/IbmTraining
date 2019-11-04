package com.ibm.mra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.mra.bean.Account;
import com.ibm.mra.dao.AccountDaoImp;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	AccountDaoImp accountDaoImp;
	
	public Account getAccountDetails(String mobileNo) {
		return accountDaoImp.getAccountDetails(mobileNo); 
	}

	public int rechargeAccount(String mobileNo, double rechargeAmount) {
		return accountDaoImp.rechargeAccount(mobileNo, rechargeAmount);
	}

}
