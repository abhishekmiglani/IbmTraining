class Table{
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int num = sc.nextInt();
		int limit = sc.nextInt();
		for(int i = 1 ; i < limit ; i++)
			System.out.println(num + " * "+ i + " = "+(num*i));
	}
}