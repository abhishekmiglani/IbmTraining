class BinaryConversion{
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int num = sc.nextInt();
		int[] binaryNum = new int[32];
		int i = 0; 
        while (num > 0) { 
            binaryNum[i] = num % 2; 
            num = num / 2; 
            i++; 
        } 
        for (int j = i - 1; j >= 0; j--) 
            System.out.print(binaryNum[j]); 

	}
}