package com.wallet.bean;

import java.util.Date;

public class Transaction {
	String accountNo;
	Double amount;
	String transactionType;
	Integer transactionNo;
	Date transactionDate;
	
	public Transaction(String accountNo, Double amount, String transactionType, Integer transactionNo,
			Date transactionDate) {
		this.accountNo = accountNo;
		this.amount = amount;
		this.transactionType = transactionType;
		this.transactionNo = transactionNo;
		this.transactionDate = transactionDate;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Integer getTransactionNo() {
		return transactionNo;
	}
	public void setTransactionNo(Integer transactionNo) {
		this.transactionNo = transactionNo;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	
}
