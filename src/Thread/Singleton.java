package Thread;

import java.lang.reflect.Constructor;

public class Singleton {
    private volatile static Singleton uniqueInstance;

    private Singleton() {
        synchronized (Singleton.class){
            if(uniqueInstance!=null)
                throw new RuntimeException("反射！");
        }
    }

    public static Singleton getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

    public static void main(String[] args) throws Exception {
//        Singleton singleton = Singleton.getUniqueInstance();
        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        Singleton singleton1 = constructor.newInstance();
        Singleton singleton2 = constructor.newInstance();
    }
}
