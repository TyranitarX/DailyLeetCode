package function;

import java.util.function.Function;

/*
        函数式接口
 */
public class Demo01 {
    public static void main(String[] args) {
        Function<String, String> function = (str) -> {
            return str;
        };

        System.out.println(function.apply("asd"));
    }
}
