import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.util.Scanner;

public class Exercise3 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		File file = new File(str);
		file.createNewFile();
		System.out.println("File Exists : "+ file.exists());
		System.out.println("is File Redable : "+ file.canRead());
		System.out.println("is file writable : "+ file.canWrite()) ;
		System.out.println("length : "+file.length());
		System.out.println();
	}
}
