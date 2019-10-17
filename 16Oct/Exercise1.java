import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exercise1 {
	public static void main(String[] args) throws IOException{
		try {
			FileWriter fw = new FileWriter(new File("file.txt")); // create an actual file
			// & a FileWriter obj
			fw.write("Hello guys\nhow\nare\nyou\ndoing\nwe\nare\nalmost\ndone\nwith\ncore"); // write characters to
			// the file
			fw.flush(); // flush before closing
			fw.close();
			BufferedReader br = new BufferedReader(new FileReader(new File("file.txt")));
			int i = 0;
			String str;
			while ((str = br.readLine())!=null) {
				i++;
				System.out.println(i + " "+str);
			}
		} catch (IOException ie) {
			System.out.println("file cannnot read");
		}
	}
}
