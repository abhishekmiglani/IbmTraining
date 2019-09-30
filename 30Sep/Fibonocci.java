class Fibonocci{
	public static void main(String[] args) {
		int num1 = 0; 
		int num2 = 1;
		System.out.print(num1 + " " + num2);
		while((num1+num2)<100)
		{
			System.out.print(num1+num2+" ");
			num2 = num1 + num2; 
        	num1 = num2 - num1; 
			
		}
	}
}
// a=1
// b=1
// b=a+b;
