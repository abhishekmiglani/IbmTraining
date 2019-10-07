import java.util.Scanner;

public class NewSplitMethod {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ;
		
		String arr[] = new NewSplitMethod().mySplit("hello world ll what ", "ll");
		for(String ar : arr) {
			System.out.println(ar);
		}
	}
	String[] mySplit(String str , String demil) {
		int counter = 0;
		for(int i=0;i+demil.length()<str.length() ; i++) {
			if(str.substring(i,i+demil.length()).equals (demil))
				counter++;
		}
		String arr[] = new  String[counter+1];
		for(int index = 0 , i = 0 ; ; i++ )
		{	
			if(str.indexOf(demil)==0) {
				str = str.substring(demil.length(),str.length());
				arr[i]="";
				
			}
			else if(str.length()==1 || str.indexOf(demil)<0 ) {
				arr[i]=str;
				break;
			}
			else if(str.indexOf(demil)>0) {
				arr[i] = str.substring(0,str.indexOf(demil));
				str = str.substring(str.indexOf(demil)+demil.length(),str.length());
				if(arr[i].equals(null))
					arr[i]="";
			}
			else
				break;
			
			
		}
		return arr;
	}
}
