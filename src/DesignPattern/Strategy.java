package DesignPattern;

import java.util.function.Supplier;

@FunctionalInterface
public interface Strategy<T> {
    T dostr();
}
