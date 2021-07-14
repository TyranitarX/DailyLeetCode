package Annotation;

import java.lang.annotation.*;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/4/19 9:13
 **/
@MyAnnotation(name = "¿", age = 12)
public class Annotation01 {
    public static void main(String[] args) {
        MyAnnotation annotation = Annotation01.class.getAnnotation(MyAnnotation.class);
        System.out.println(annotation.name());
    }
}

/**
 * target:注解用在哪些地方
 * retention:表示注解在编程声明周期何时有效RUNTIME>CLASS>SOURCE
 * documented：是否将我们的注解生成在javadoc中
 * inherited: 子类可以继承父类中的该注解
 */
@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String name() default "";

    int age() default 18;
}
