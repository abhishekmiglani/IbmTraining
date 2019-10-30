package com.wallet.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wallet.bean.Customer;
import com.wallet.dao.WalletData;
import com.wallet.dao.WalletDataInt;

public class CustomerAccountDetailsService implements CustomerAccountDetailsServiceInt {

	WalletDataInt wd = null;

	public CustomerAccountDetailsService(Connection con) {
		try {
			wd = new WalletData(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("There is some issue with Data layer");
		}
	}
	public Customer showAccountDetails(String accountNo) throws SQLException {
		try {
			return wd.retriveUserInformation(accountNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public boolean lowBalanceAlert(String accountNo) {
		double accountBalance = wd.retriveAccountBalance(accountNo);
		if(accountBalance<=0)
			return false;
		return true;
	}

	public boolean deposit(String accountNo, double amount) throws SQLException {
		// TODO Auto-generated method stub
		
			try {
				return wd.depositMoney(accountNo,amount);
			} catch (SQLException e) {
				System.out.println("line no 46 CustomerAccountDetailsService.java");
			}
			return false;
	}

	public boolean withdraw(String accountNo, double amount)  {
		try {
			return wd.withdrawMoney(accountNo,amount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("withdraw() CustomerAccountDetailService.java");
		}
		return false;
	}

	public boolean fundTransfer(String senderAccountNo, String receiverAccountNo, double amount) {
		return wd.fundTransfer(senderAccountNo,receiverAccountNo,amount);
	}

	public ArrayList<com.wallet.bean.Transaction> printTransaction(String accountNo) {
		return wd.retriveTransactionInfo(accountNo);
		
	}

}
