import java.io.IOException;
import java.util.logging.ConsoleHandler;

public class Timer extends Thread{
	public static void main(String[] args) {
		Timer t = new Timer();
		t.start();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0 ; ; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("exception caught");
			}
			System.out.print("\b"+i); 
		}
	}
}
