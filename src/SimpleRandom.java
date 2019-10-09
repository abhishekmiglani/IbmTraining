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
}

// Note that the result can not be bigger then 32749
public int nextInt(){
    last = (last * 32719 + 3) % 32749;
    return last % max;
}
}
