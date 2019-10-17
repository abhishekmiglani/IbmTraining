import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProgram {
	public static void main(String[] args) throws IOException, InterruptedException {
		CopyDataThread copyDataThread = new CopyDataThread();
	}
}
class CopyDataThread extends Thread {
	CopyDataThread() throws IOException, InterruptedException{
		FileReader fr = new FileReader("source.txt");
		FileWriter fw = new FileWriter("target.txt");
		int c,i=1;
		while((c = fr.read())!=-1) {
			fw.write((char)c);
			i++;
			if(i%10==0) {
				System.out.println("10 character written");
				this.sleep(1000);
			}
		}
	}
	
}
