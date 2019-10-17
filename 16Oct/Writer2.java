import java.io.*;
public class Writer2 {
public static void main(String [] args) throws IOException {
char[] in = new char[100]; // to store input
int size = 0;
File file = new File("anotherFile.docx"); //Again this is just an object
file.createNewFile(); 
try {
  
 
FileWriter fw = new FileWriter(file); // create an actual file
// & a FileWriter obj
fw.write("Hello\nguys\nhow\nare\nyou\ndoing\nwe\nare\nalmost\ndone\nwith\ncore"); // write characters to
// the file
fw.flush(); // flush before closing
fw.close(); // close file when done
} catch(IOException e) {
    System.out.println("Can't write to the file currently...");
 }
}
}