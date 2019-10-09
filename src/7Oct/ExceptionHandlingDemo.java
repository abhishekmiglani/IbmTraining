
public class ExceptionHandlingDemo {
	void func(int num,int den){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("Enter two numbers");
		num = sc.nextInt();
		den = sc.nextInt();
		
		int result = 0;
		try {
			result = num / den;      
	        System.out.println("Division : " + result);
	         
	        }
//		catch(ArithmeticException ae){
//	        	System.out.println("0 is not acceptable as second number kindly put appropriate numbers");
//	             new ExceptionHandlingDemo().func(45,5);
//	        }
		finally {
			System.out.println("hello");
		}
		sc.close();
	}
	public static void main(String[] args) {
		new ExceptionHandlingDemo().func(45, 0);
	}
}
