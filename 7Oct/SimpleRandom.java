public class SimpleRandom {
public static void main(String[] args) throws InterruptedException {
    SimpleRandom rand = new SimpleRandom(100);
    for (int i = 0; i < 10; i++) {
        System.out.print(rand.nextInt()+ " ");
        Thread.sleep(1000);
    }

}

private int max;
private int last;

public SimpleRandom(int max){
    this.max = max;
    last = (int) (System.currentTimeMillis() % max);
    System.out.println(last);
}
public int nextInt(){
    last = last * 52719 % 2749;
    return last % max;
}
}
