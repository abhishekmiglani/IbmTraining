package lab2;

import java.util.Scanner;

public class FlowControlAndFlowControlAndExceptionHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TrafficLight tl = new TrafficLight();
//		tl.light(tl.askUser());

//		FibonacciSequence fs = new FibonacciSequence();
//		System.out.println(fs.recursive(1, 1));
//		fs.nonRecursive(100);

//		PrimeNumber pn = new PrimeNumber();
//		System.out.println(pn.checkPrime(89));
//		pn.printPrime(100);

//		try {
//			ValidatingName vn = new ValidatingName("La", "hi");
//		} catch (EmptyNameException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Exception Caught");
//		}
//		
		
		
	}

}

//Exercise 1---------------
class TrafficLight {
	void light(String color) {
		switch (color) {
		case "Red":
			System.out.println("Stop");
			break;
		case "Yellow":
			System.out.println("Ready");
			break;
		case "Green":
			System.out.println("Go");
			break;
		default:
			System.out.println("Nothing");

		}

	}

	String askUser() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Select one of the following : /n 1. Red /n 2. Yellow/n 3. Green");
		int choice = sc.nextInt();
		sc.close();
		switch (choice) {
		case 1:
			return "Red";
		case 2:
			return "Red";
		case 3:
			return "Red";
		default:
			return "no light";

		}
	}
}

//Exercise 2----------------
class FibonacciSequence {
	int recursive(int n, int m) {
		if (m < 100) {
			System.out.print(m + " ");
			return recursive(m, n + m);
		} else
			return 0;
	}

	void nonRecursive(int n) {
		int a = 1;
		int b = 1;
		while (b < n) {
			System.out.print(b + " ");
			b = a + b;
			a = b - a;

		}
	}
}

//Exercise 3-------------------
class PrimeNumber {
	boolean checkPrime(int n) {
		boolean flag = false;
		if (n == 2 || n == 3 || n == 5)
			return true;
		for (int i = 2; i < n / 2; i++) {
			if (n % i == 0) {
				flag = false;
				break;
			} else
				flag = true;
		}
		return flag;
	}

	void printPrime(int n) {
		int k = 0;
		for (int i = 2; i < n; i++) {
			if (checkPrime(i) == true) {
				k++;
				System.out.print(i + "  ");
			}
		}
	}
}

//Exercise 4-------------------
class EmptyNameException extends Exception{

	public EmptyNameException(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
}

class ValidatingName{
	private String firstName;
	private String lastName;
	ValidatingName(String firstName , String lastName) throws EmptyNameException{
	if(firstName.equals("") || lastName.equals(""))
		throw new EmptyNameException("Name cannnot be Empty");
	}
	
}

//Exercise 5-------------------

class AgeValidException extends Exception{

	public AgeValidException(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
}
class ValidatingAge {
	private int age;

	public ValidatingAge(int age) throws AgeValidException {
		if(age<15)
			throw new AgeValidException("Age should be greater than 15");
	}
	
}



