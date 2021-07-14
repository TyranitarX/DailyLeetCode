package Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    private static final int QUEUE_CAPACITY = 10;
    private static final long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        /*
        四种拒绝策略
         */
        for (int i = 0; i < 10; i++) {
            Runnable woker = new MyRunnable("" + i);
            executor.execute(woker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finish ALL Threads!");
    }
}
