package com.wallet.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.wallet.bean.Customer;
import com.wallet.bean.Transaction;

public interface CustomerAccountDetailsServiceInt {

	Customer showAccountDetails(String accountNo) throws SQLException;
	boolean lowBalanceAlert(String accountNo);
	boolean deposit(String accountNo , double amount) throws SQLException;
	boolean withdraw(String accountNo , double amount);
	boolean fundTransfer(String senderAccountNo , String receiverAccountNo , double amount);
	ArrayList<Transaction> printTransaction(String accountNo);
}
