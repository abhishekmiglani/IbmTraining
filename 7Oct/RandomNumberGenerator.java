
public class RandomNumberGenerator extends Thread {
//	static String num;
//	String generateRandom() {
//		RandomNumberGenerator[] arr = new RandomNumberGenerator[10];
//		for(int i = 0 ; i <10 ; i++)
//			arr[i] = new RandomNumberGenerator();
//		
//		for(int i = 0 ; i<10 ; i++) {
//			arr[i].start();
//		}
//			
//		return num;
//	}
//	
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		num = Thread.currentThread().getName();
//	}
//	
//	public static void main(String[] args) throws InterruptedException {
//		RandomNumberGenerator gg = new RandomNumberGenerator();
//		for(int i = 0 ; i<10; i++) {
//		
//		System.out.print(gg.generateRandom() + " ");
//		Thread.sleep(2000);
//		}
//	}
	
	
	public static void main(String[] args) {
		for(int i = 0 ; ;i++) {
		Long num = System.currentTimeMillis();
		
		System.out.print(num % 9/*.substring(11,12)*/+ " ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
}
