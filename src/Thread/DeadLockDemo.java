package Thread;

public class DeadLockDemo {
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get Resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("waiting get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get Resource2");
                }
            }
        }, "线程a").start();
        new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread() + "get Resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("waiting get resource1");
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + "get Resource1");
                }
            }
        }, "线程b").start();
    }

}
