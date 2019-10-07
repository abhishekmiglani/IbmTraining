import java.util.Scanner;

public class ReverseString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ;
		String str = sc.next();
		System.out.println(new ReverseString().reverse(str));
		
	}
	String reverse(String str) {
		String var ="";
		for(int i = str.length()-1 ; i>=0 ; i-- ) 
			var = var + str.charAt(i);
		return var;
	}
}
