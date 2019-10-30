package com.wallet.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wallet.bean.Customer;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection con = null;
		if (request.getServletContext().getAttribute("con") instanceof Connection) {
			con = (Connection) request.getServletContext().getAttribute("con");
		}
		if (con != null) {
			String customerName = request.getParameter("customerName");
			String accountType = request.getParameter("accounttype");
			String mobileNo = request.getParameter("mobileNo");
			int age = Integer.parseInt(request.getParameter("age"));
			String password = request.getParameter("password");
			
			Customer customer = new Customer(customerName, accountType, mobileNo, age, password);
			if(new CustomerCreatingService(con).passToData(customer))
				out.print("Wallet and Account is ready<a href='index.jsp'>Login Here</a>");
			else
				out.print("Some error try again later");
			
		}
		
	}

}
