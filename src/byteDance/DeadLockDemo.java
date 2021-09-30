package byteDance;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/27 10:56
 **/


public class DeadLockDemo {
    static Object resource1 = new Object();
    static Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("waittoget2");
                synchronized (resource2) {
                    System.out.println("fin1!");
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (resource2) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("waittoget1");
                synchronized (resource1) {
                    System.out.println("fin2!");
                }
            }
        }).start();
    }
}
