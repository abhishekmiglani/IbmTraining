import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Exercise2 {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader(new File("file.txt"));
		int noOfWord = 0;
		int noOfLine = 0;
		char in[] = new char[1000];
		int size = fr.read(in);
		for (char c : in) {
			if(c==' ' || c=='\n')
			noOfWord++;
		}
		for (char c : in) {
			if(c=='\n')
			noOfLine++;
		}
		
		System.out.println("No of words : " + noOfWord );
		System.out.println("no of Character are : " + size);
		System.out.println("No of Line : " + noOfLine);
	}
}
