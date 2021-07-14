package JMM;

import java.util.concurrent.atomic.AtomicInteger;

public class JmmDemo2 {
    public static AtomicInteger num = new AtomicInteger(0);

    public static void add() {
        num.incrementAndGet();
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(num);
    }

}
