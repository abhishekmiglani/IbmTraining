class FactorialOfaNumber{
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int num1 = sc.nextInt();
		int factorial = 1;
		for(;num1>1;num1--)
		{
			factorial = factorial*num1;
		}	
		System.out.println(factorial);
	}
}