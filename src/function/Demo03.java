package function;

import java.util.function.Consumer;

/*
       消费型接口 //只有输入没有返回值
 */
public class Demo03 {
    public static void main(String[] args) {
        Consumer<String> consumer = System.out::println;

        consumer.accept("好");
    }
}
