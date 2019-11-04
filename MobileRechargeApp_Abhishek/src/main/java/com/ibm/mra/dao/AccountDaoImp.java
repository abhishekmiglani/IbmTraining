package com.ibm.mra.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ibm.mra.bean.Account;

@Repository
public class AccountDaoImp implements AccountDao {
	@Autowired
	DataSource dataSource;
	@Autowired
	NamedParameterJdbcTemplate namedTemplate;

	public Account getAccountDetails(String mobileNo) {
		String retriveQuery = "Select * from account_details where mobileNo=:mobileNo";
		return namedTemplate.queryForObject(retriveQuery, new MapSqlParameterSource("mobileNo", mobileNo),
				new AccountMapper());
	}

	public int rechargeAccount(String mobileNo, double rechargeAmount) {
		String retriveSql = "select balance from account_details where mobileNo=:mobileNo";
		double balance = namedTemplate.queryForObject(retriveSql, new MapSqlParameterSource("mobileNo", mobileNo),
				Double.class);

		String sql = "update account_details set balance=:updatedAmount";
		if (namedTemplate.update(sql, new MapSqlParameterSource("updatedAmount", balance + rechargeAmount)) == 1)
			return (int) (balance + rechargeAmount);
		else
			return (int) balance;
	}

	class AccountMapper implements RowMapper<Account> {
//		@Repository
//		Account account;
		public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
			Account account = new Account();
			account.setCustomerName(rs.getString("Name"));
			account.setAccountBalance(rs.getDouble("Balance"));
			account.setAccountType(rs.getString("Type"));

			return account;
		}

	}

}
