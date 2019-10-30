<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.wallet.bean.Customer,java.sql.SQLException , com.wallet.service.CustomerAccountDetailsService" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<% Customer customer = (Customer)request.getAttribute("customer");
	CustomerAccountDetailsService caService = (CustomerAccountDetailsService)request.getAttribute("caService");
	%>
<script>
	function getBalance(){
		document.getElementById('accountBalance').innerHTML = <%=customer.getAccountBalance()%> 
		console.log("got balance");
		
		if(<%=customer.getAccountBalance()%><=0)
			document.getElementById('lowAccountBalanceAlert').innerHTML = "Your Account Balance is low kindly Deposit some money";
	}
	function getWalletBalance(){
		document.getElementById('walletBalance').innerHTML = <%=customer.getWalletBalance()%> 
		console.log("got wallet balance");
		
		if(<%=customer.getWalletBalance()%><=0)
			document.getElementById('lowWalletBalanceAlert').innerHTML = "Your Wallet Balance is low kindly Deposit some money";
	}	
</script>
<body>
 	<div>Hello <%=customer.getCustomerName()%></div>
 	
 	
 	<br><button onclick = "getBalance()"> Get Balance : </button><label>&#8377</label><label id="accountBalance"></label><br>
 	<label id="lowAccountBalanceAlert"></label><br>
 	<button onclick = "getWalletBalance()"> Get Wallet Balance : </button><label>&#8377</label><label id="walletBalance"></label><br>
 	<label id="lowWalletBalanceAlert"></label><br>
 	<form action="cas">
 	<input type="number" placeholder= "Enter the amount you want to deposit"  name="depositValue">
 	<input type="submit" value="Deposit"></form><br>
 	<form action="cas">
 	<input type="number" placeholder= "Enter the amount you want to deposit"  name="withdrawValue">
 	<input type="submit" value="Withdraw"></form><br>
 	
 	
 	<form action="cas">
 		<input type="number" placeholder="Beneficiary Account no" name="receiverAccountNo" maxLength="10">
 		<input type="number" placeholder="Amount" name="transferValue">
 		<input type="submit" value="Transfer Value">
 	</form>
 	
 	<a href="cas"><button>Print All Transactions</button></a>
 	
</body>
</html>