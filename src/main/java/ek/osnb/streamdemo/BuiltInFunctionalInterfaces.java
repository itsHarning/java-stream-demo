package ek.osnb.streamdemo;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuiltInFunctionalInterfaces {
    public static void main(String[] args) {

        // TODO: Predicate isEven
        Predicate<Integer> isEven = a -> a % 2 == 0;
        System.out.println(isEven.test(10));

        // TODO: Consumer printUpperCase
        Consumer<String> printUpperCase = a -> System.out.println(a.toUpperCase());
        printUpperCase.accept("hello world!");

        // TODO: Supplier randomValueSupplier
        Supplier<Double> randomValueSupplier = () -> Math.random();
        System.out.println(randomValueSupplier.get());

        // TODO: Function squareFunction
        Function<Double,Double> squareFunction = a -> a * a;
        System.out.println(squareFunction.apply(4.0));

        // TODO: Predicate Usage

        // TODO: Consumer Usage

        // TODO: Supplier Usage

        // TODO: Function Usage

        // TODO: Chaining Predicate: isAbove + isEven
        Predicate<Integer> isAbove = n -> n > 10;
        Predicate<Integer> combinedPredicate = isEven.or(isAbove);
        System.out.println(combinedPredicate.test(10));

        // TODO: Chaining Functions: add3 then square
        Function<Double,Double> add3 = n -> n +3;
        Function<Double, Double> combinedFunction = squareFunction.andThen(add3);
        System.out.println(combinedFunction.apply(2.0));

        // TODO: Chaining Consumers: printUpperCase then print length
        Consumer<String> printLength = s -> System.out.println(s.length());
        Consumer<String> combinedConsumer = printLength.andThen(printUpperCase);
        combinedConsumer.accept("asdfasdf");


    }
}
