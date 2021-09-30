package byteDance;

import java.util.concurrent.Semaphore;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/28 17:39
 **/
public class ThreadTest {
    static Semaphore semaphoreA = new Semaphore(1);
    static Semaphore semaphoreB = new Semaphore(0);

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 10; i += 2) {
                try {
                    semaphoreA.acquire();
                    System.out.print("i'm" + Thread.currentThread().getName()+" ");
                    System.out.println(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphoreB.release();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i < 10; i += 2) {
                try {
                    semaphoreB.acquire();
                    System.out.print("i'm" + Thread.currentThread().getName()+" ");
                    System.out.println(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphoreA.release();
                }
            }
        }, "B").start();
    }
}
