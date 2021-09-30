package byteDance;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/27 11:17
 **/
public class SingletonDemo {
    private static volatile SingletonDemo instance;

    private SingletonDemo() {
    }

    public static SingletonDemo getinstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }
}
