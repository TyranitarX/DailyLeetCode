package function;

import java.util.Arrays;
import java.util.function.Supplier;

/*
        供给型接口 无输入
 */
public class Demo04 {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> {
            System.out.println(123);
            return null;
        };
        supplier.get();
    }
}
