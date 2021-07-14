package Thread;

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalExample implements Runnable {
    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));

    @Override
    public void run() {
        System.out.println("Threadname=" + Thread.currentThread().getName() + "default Formatter=" + formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        formatter.set(new SimpleDateFormat());
        System.out.println("Threadname=" + Thread.currentThread().getName() + "Formatter=" + formatter.get().toPattern());
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample le = new ThreadLocalExample();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(le, "" + i);
            Thread.sleep(1000);
            t.start();
        }
    }
}
