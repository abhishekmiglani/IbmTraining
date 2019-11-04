package com.ibm.mra.ui;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.mra.service.AccountServiceImpl;
import com.ibm.mra.service.AccountValidationImp;

public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AppContext.xml");
		AccountValidationImp accountValidationImp = context.getBean("accountValidationImp", AccountValidationImp.class);
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your mobile No : ");
		String mobile = sc.next();
		while (!accountValidationImp.validateMobileNumber(mobile)) {
			System.out.println("Enter 10 digit mobile no : ");
			mobile = sc.next();
		}
		while(!accountValidationImp.validateAccount(mobile)) {
			System.out.println("ERROR: Given Account Id Does Not Exists");
				mobile = sc.next();
		}
		if (accountValidationImp.validateAccount(mobile)) {
			System.out.println("Your Current Account Balance is : "
					+ context.getBean("accountServiceImpl", AccountServiceImpl.class).getAccountDetails(mobile)
							.getAccountBalance());
			System.out.println("Enter 1  to Recharge and 2 to exit");

			int choice = sc.nextInt();
			System.out.println("Enter the amount");
			while(choice == 1) {
				double rechargeAmount = sc.nextDouble();
				System.out.println("Your Account Recharged Successfully \nHello"
						+ context.getBean("accountServiceImpl", AccountServiceImpl.class).getAccountDetails(mobile)
								.getCustomerName()
						+ ",Available Balance is" + context.getBean("accountServiceImpl", AccountServiceImpl.class)
								.rechargeAccount(mobile, rechargeAmount));

			}
		}
	}
}
