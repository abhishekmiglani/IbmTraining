import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercise4 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String str ;
		String s = sc.next();
		String p = sc.next();
		BufferedReader br = new BufferedReader(new FileReader("file.txt"));
		String temp = "";
		
		while ((str= br.readLine())!=null) {
			
			temp = temp+str;
		}
		System.out.println(temp);
		temp = temp.replaceAll(s, p);
		System.out.println(temp);
		BufferedWriter bw = new BufferedWriter(new FileWriter("file.txt"));
		bw.write(temp);
		bw.flush();
		
	}
}
