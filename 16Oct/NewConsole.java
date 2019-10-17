import java.io.Console;
    
   public class NewConsole {
     public static void main(String[] args) {
       String uName = "";
       Console theConsole = System.console();
       char[] passW;
       passW = theConsole.readPassword("%s", "Your Password: ");
       for(char pwVal: passW)
         theConsole.format("%c ", pwVal);
 
       theConsole.format("\n");
        
       MyUtilityClass mu = new MyUtilityClass();
       while(true) {
         uName = theConsole.readLine("%s", "input?: ");
// #1: get a Console
// #2: return a char[]
// #3: format output
// #4: return a String
  theConsole.format("output: %s \n", mu.doStuff(uName));
}
} }
class MyUtilityClass {
  String doStuff(String arg1) {
// stub code
    return "result is " + arg1;
  }
}