import java.util.Scanner;

public class StringPalindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ;
		String var  = sc.next();
		System.out.println(new StringPalindrome().palindrome(var));
	}
	
	boolean palindrome(String s){
		boolean flag = false;
		for(int i = 0 , j = s.length()-1 ; i < s.length()/2 ; i++ , j--) 
			if(s.charAt(i)==s.charAt(j)) 
				flag=true;
			else {
				flag=false;
				break;
			}
		return flag;
		}
	}
	
