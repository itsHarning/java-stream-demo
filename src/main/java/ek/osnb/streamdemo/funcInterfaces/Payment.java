package ek.osnb.streamdemo.funcInterfaces;

import java.util.function.Consumer;

@FunctionalInterface
public interface Payment extends Consumer<Double> {

    void pay(double amount);

    default void accept(Double amount) {
        before();
        pay(amount);
        after();
    }

    default void before() {}
    default void after() {}

}
