package ek.osnb.streamdemo.funcInterfaces;

import java.util.function.Consumer;

@FunctionalInterface
public interface Payment {
    void pay(double amount);

    default void before() {}
    default void after() {}

    default void execute(double amount) {
        before();
        pay(amount);
        after();
    }
}
