package com.ibm.mra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ibm.mra.dao.AccountDaoImp;

@Service
public class AccountValidationImp implements AccountValidation {
	@Autowired
	AccountDaoImp accountDaoImp;

	public boolean validateMobileNumber(String mobileNo) {
		if (mobileNo.length() == 10)
			return true;
		return false;
	}

	public boolean validateAccount(String mobileNo) {
		// TODO Auto-generated method stub
		try {
		if(accountDaoImp.getAccountDetails(mobileNo).equals(""))
			return false;
		else
			return true;
		}
		catch(EmptyResultDataAccessException e){
			return false;
		}
	}

}
