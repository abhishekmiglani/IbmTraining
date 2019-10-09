
public class PropogationOfExceptionDemo {
	public static void main(String[] args) throws Exception {
//		try{
			new PropogationOfExceptionDemo().display();
//		}catch (Exception e) {
//			System.out.println("Its illegal to use \"0\" as second Number");
//		}
		
	}
	void display() throws Exception{
		
		System.out.println(div(100,0));
	}
	int div(int op1 , int op2 ) throws Exception{
		try
		{
			return op1/op2;
		}
//		finally {
//			System.out.println("Hello");
//			
//		}
		catch(ArithmeticException ai) {
			return 9;
		}
//		System.out.println("lites"); //unreacheable code
		
	}
}
