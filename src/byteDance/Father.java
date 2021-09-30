package byteDance;


/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/27 10:34
 **/
public class Father {
    public void fun1(Object o) {
        System.out.println("objfun");
        System.out.println(o);
    }

    public void fun1(String s) {
        System.out.println("stringfun");
        System.out.println(s);
    }


    public static void main(String[] args) {
        new Father().fun1(null);
    }
}
