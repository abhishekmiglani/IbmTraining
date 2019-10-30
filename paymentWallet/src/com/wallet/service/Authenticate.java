package com.wallet.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wallet.bean.Customer;

@WebServlet("/authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection con = null;
		if (request.getServletContext().getAttribute("con") instanceof Connection) {
			con = (Connection) request.getServletContext().getAttribute("con");
		}
		if (con != null) {
			
			String accountNo  = request.getParameter("accountNo");
			String password = request.getParameter("password");
			HttpSession session = request.getSession();
			session.setAttribute("accountNo", accountNo);
			System.out.println(session.getAttribute("accountNo"));
			
			if (new CustomerCreatingService(con).validatePassword(accountNo,password)) {
				Cookie cookie = new Cookie("name", accountNo);
				response.addCookie(cookie);
				Customer customer = null;
				try {
					customer = new CustomerAccountDetailsService(con).showAccountDetails(accountNo);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Eror retrieveing customer data");
				}
				if(customer!=null)
					System.out.println("customer is not null");
				request.setAttribute("customer", customer);		
				request.setAttribute("caService", new CustomerAccountDetailsService(con));
				request.getRequestDispatcher("dashboard.jsp").forward(request, response);
				
			}
				
			else {
				out.println("<script>"
						+ "alert('Wrong Credentials')"
						+ "</script>");
				request.getRequestDispatcher("index.jsp").include(request, response);
			}
		}

		
	}
}
