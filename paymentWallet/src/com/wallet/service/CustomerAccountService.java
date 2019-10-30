package com.wallet.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.wallet.bean.Customer;
import com.wallet.bean.Transaction;

/**
 * Servlet implementation class CustomerAccountService
 */
@WebServlet("/cas")
public class CustomerAccountService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection con = null;
		if (request.getServletContext().getAttribute("con") instanceof Connection) {
			con = (Connection) request.getServletContext().getAttribute("con");
		}
		if (con != null) {
			String accountNo = (String) request.getSession().getAttribute("accountNo");
			CustomerAccountDetailsService accountDetailsService = new CustomerAccountDetailsService(con);
			if (request.getParameter("withdrawValue") != null) {
				accountDetailsService.withdraw(accountNo, Double.parseDouble(request.getParameter("withdrawValue")));
				out.print("<script>alert('money withdrawl')</script>");
				request.getRequestDispatcher("dashboard.jsp");

			} else if (request.getParameter("depositValue") != null) {
				try {
					accountDetailsService.deposit(accountNo, Double.parseDouble(request.getParameter("depositValue")));
					out.print("<script>alert('money Deposited')</script>");

				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Time out Can't deposit money");
				}

			} else if (request.getParameter("transferValue") != null) {
				String receiverAccountNo = request.getParameter("receiverAccountNo");
				double amount = Double.parseDouble(request.getParameter("transferValue"));
				accountDetailsService.fundTransfer(accountNo, receiverAccountNo, amount);
				out.print("<script>alert('money transfered')</script>");
			} else {
				ArrayList<Transaction> al = accountDetailsService.printTransaction(accountNo);
				out.print("<table style='border:black 1px solid'>" + 
						"    <tr>" + 
						"        <th>Date</th>" + 
						"        <th>Amount</th>" + 
						"        <th>Type</th>" + 
						"    </tr>");
				for (Transaction transaction : al) {
					out.print("    <tr>" + 
							"        <td>"+transaction.getTransactionDate()+"</td>" + 
							"        <td>"+transaction.getAmount()+"</td>" + 
							"        <td>"+transaction.getTransactionType()+"</td>" + 
							"    </tr>" );
				}		
				out.print("</table>");
				
			}
		}
	}
}
