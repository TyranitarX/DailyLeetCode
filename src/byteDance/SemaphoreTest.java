package byteDance;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    static Semaphore semaphore1 = new Semaphore(1);
    static Semaphore semaphore2 = new Semaphore(0);
    static Semaphore semaphore3 = new Semaphore(0);

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    semaphore1.acquire();
                    System.out.println("A");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    semaphore2.release();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    semaphore2.acquire();
                    System.out.println("B");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    semaphore3.release();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    semaphore3.acquire();
                    System.out.println("C");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    semaphore1.release();
                }
            }
        }).start();
    }
}
