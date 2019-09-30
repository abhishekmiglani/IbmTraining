class SumCheck{
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		int flag = 0;
		if(num1>=40)
			flag++;
		if(num2>=40)
			flag++;
		if(num3>=40)
			flag++;
		if(num1+num2+num3>=125)
			flag++;
		if(flag==4)
			System.out.println("Passing");
		if(flag!=4)
			System.out.println("Failing");

		
	}
}