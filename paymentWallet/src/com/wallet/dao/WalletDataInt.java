package com.wallet.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.wallet.bean.Customer;
import com.wallet.bean.Transaction;

public interface WalletDataInt {
	
	public boolean validatingAccount(String accountNo);

	public boolean storeInDatabase(Customer customer) throws SQLException;

	public boolean validatePassword(String mobileNo, String password);

	public Customer retriveUserInformation(String accountNo) throws SQLException;

	public double retriveAccountBalance(String accountNo);

	public boolean depositMoney(String accountNo, double amount) throws SQLException;

	public boolean withdrawMoney(String accountNo, double amount) throws SQLException;

	public boolean fundTransfer(String senderAccountNo, String receiverAccountNo, double amount);

	public ArrayList<Transaction> retriveTransactionInfo(String accountNo);
}
