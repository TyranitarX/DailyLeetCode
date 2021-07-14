package function;


import java.util.function.Predicate;

/*
    断定型接口
 */
public class Demo02 {
    public static void main(String[] args) {
        Predicate<String> predicate = String::isEmpty;
        System.out.println(predicate.test(""));
    }
}
