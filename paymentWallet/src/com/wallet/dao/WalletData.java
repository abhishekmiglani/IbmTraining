package com.wallet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletContext;

import com.wallet.bean.Customer;
import com.wallet.bean.Transaction;

public class WalletData implements WalletDataInt {
	public Connection con = null;
	PreparedStatement pstmt = null;

	public WalletData(Connection con) throws SQLException {
		this.con = con;
	}

	public boolean validatingAccount(String accountNo) {
		try {
			pstmt = con.prepareStatement("Select accountNo from customer_account_details where accountNo = ?");
			pstmt.setString(1, accountNo);
			if (pstmt.executeQuery().next() == false)
				return true;
			else
				return false;
		} catch (SQLException e) {
			System.out.println("There is something wrong with account validation query!!! line no 33 walletdata.java");
		}
		return false;

	}

	public boolean storeInDatabase(Customer customer) throws SQLException {
		try {
			pstmt = con.prepareStatement(
					"insert into customer_account_details (accountNo, walletId, mobileNo, customerName, accountType, accountBalance,"
							+ " walletBalance, age , password) values (?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, customer.getAccountNo());
			pstmt.setString(2, customer.getWalletId());
			pstmt.setString(3, customer.getMobileNo());
			pstmt.setString(4, customer.getCustomerName());
			pstmt.setString(5, customer.getAccountType());
			pstmt.setDouble(6, customer.getAccountBalance());
			pstmt.setDouble(7, customer.getWalletBalance());
			pstmt.setInt(8, customer.getAge());
			pstmt.setString(9, customer.getPassword());

			if (pstmt.executeUpdate()==1)
				return true;
			else
				return false;

		} catch (SQLException e) {
			System.out.println("line no 61 walletData.java"+e.getMessage());
		}
		return false;
	}

	public boolean validatePassword(String mobileNo, String password) {
		try {
			pstmt = con.prepareStatement("Select password from customer_account_details where mobileNo = ?");
			pstmt.setString(1, mobileNo);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			String s = rs.getString(1);
			if (rs.getString(1).equals(password))
				return true;
			else
				return false;
		} catch (SQLException e) {
			System.out.println("There is something wrong with account validation query!!!");
		}
		return false;
	}

	public Customer retriveUserInformation(String accountNo) throws SQLException {

		try {
			pstmt = con.prepareStatement("select * from customer_account_details where accountNo = ?");
			pstmt.setString(1, accountNo);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return new Customer(rs.getString("accountNo"), rs.getString("walletId"), rs.getString("mobileNo"), 
					rs.getString("customerName"), rs.getString("accountType"), rs.getDouble("accountBalance"), rs.getDouble("walletBalance"), rs.getInt("age"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while retrieving user info line 96 walletData.java");
		}
		return null;

		
	}

	public double retriveAccountBalance(String accountNo) {
		
		try {
			pstmt = con.prepareStatement("select accountBalance from customer_account_details where accountNo = ?");
			pstmt.setString(1, accountNo);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getDouble("accountBalance");

		} catch (SQLException e) {
			System.out.println("Error while retrieving user info retriveAccountbalance() walletData.java" + e.getMessage());
		}
		return 0;
		
	}

	public boolean depositMoney(String accountNo, double amount) throws SQLException {
		
		try {
			pstmt = con.prepareStatement("insert into account_transaction_details (accountNo, amount, transactionType) values (?,?,?)");
			pstmt.setString(1, accountNo);
			pstmt.setDouble(2, amount);
			pstmt.setString(3,"credit");
			if(pstmt.executeUpdate()==1)
			{
				amount = amount + retriveAccountBalance(accountNo);
				pstmt = con.prepareStatement("update customer_account_details set accountBalance = ? where accountNo = ?");
				pstmt.setDouble(1, amount);
				pstmt.setString(2, accountNo);
				
				if(pstmt.executeUpdate()==1)
					return true;
			}
			else {
				pstmt = con.prepareStatement("rollback");
				pstmt.execute();
			}
		} catch (SQLException e) {
			System.out.println("depositMoney() walletData.java " + e.getMessage());
//			e.printStackTrace();
		}
		return false;
	}

	
	public boolean withdrawMoney(String accountNo, double amount) throws SQLException{
		try {
			pstmt = con.prepareStatement("insert into account_transaction_details (accountNo, amount, transactionType) values (?,?,?)");
			pstmt.setString(1, accountNo);
			pstmt.setDouble(2, amount);
			pstmt.setString(3,"debit");
			if(pstmt.executeUpdate()==1)
			{
				amount = retriveAccountBalance(accountNo)-amount;
				pstmt = con.prepareStatement("update customer_account_details set accountBalance = ? where accountNo = ?");
				pstmt.setDouble(1, amount);
				pstmt.setString(2, accountNo);
				
				if(pstmt.executeUpdate()==1)
					return true;
			}
			else {
				pstmt = con.prepareStatement("rollback");
				pstmt.execute();
			}
		} catch (SQLException e) {
			System.out.println("withdraw money WalletData.java");
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean fundTransfer(String senderAccountNo, String receiverAccountNo, double amount) {
		boolean flag = false;
		double tempAmount = amount;
		try {
			pstmt = con.prepareStatement("insert into account_transaction_details (accountNo, amount, transactionType) values (?,?,?)");
			pstmt.setString(1, receiverAccountNo);
			pstmt.setDouble(2, amount);
			pstmt.setString(3,"credit");
			if(pstmt.executeUpdate()==1)
			{
				amount = amount + retriveAccountBalance(receiverAccountNo);
				pstmt = con.prepareStatement("update customer_account_details set accountBalance = ? where accountNo = ?");
				pstmt.setDouble(1, amount);
				pstmt.setString(2, receiverAccountNo);
				
				if(pstmt.executeUpdate()==1)
					flag = true;
			}
			else {
				flag = false;
				if(flag==false)
					return false;
				pstmt = con.prepareStatement("rollback");
				pstmt.execute();
			}
			amount = tempAmount;
			pstmt = con.prepareStatement("insert into account_transaction_details (accountNo, amount, transactionType) values (?,?,?)");
			pstmt.setString(1, senderAccountNo);
			pstmt.setDouble(2, amount);
			pstmt.setString(3,"debit");
			if(pstmt.executeUpdate()==1)
			{
				amount = retriveAccountBalance(senderAccountNo)-amount;
				pstmt = con.prepareStatement("update customer_account_details set accountBalance = ? where accountNo = ?");
				pstmt.setDouble(1, amount);
				pstmt.setString(2, senderAccountNo);
				
				if(pstmt.executeUpdate()==1)
					flag = true;
			}
			else {
				flag = false;
				if(flag==false)
					return false;
				pstmt = con.prepareStatement("rollback");
				pstmt.execute();
			}
			
			if(flag==true)
				return true;
		} catch (SQLException e) {
			System.out.println("fundtransfer() walletData.java " + e.getMessage());
//			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Transaction> retriveTransactionInfo(String accountNo) {
		ArrayList<Transaction> al = new ArrayList();
		try {
			pstmt = con.prepareStatement("select * from account_transaction_details where accountNo=?");
			pstmt.setString(1, accountNo);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				al.add(new Transaction(rs.getString(1), rs.getDouble(2), rs.getString(3), rs.getInt(4),rs.getDate(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("printTransactions walletData.java");
		}
		
		return al;
	}
}
