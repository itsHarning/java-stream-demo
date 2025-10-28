package ek.osnb.streamdemo;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Streams01 {
    enum Type { SEDAN, SUV, TRUCK, COUPE }
    record Car(String make, String model, int year, Type type) {}

    public static void main(String[] args) {
        List<Car> cars = List.of(
                new Car("Toyota", "Camry", 2020, Type.SEDAN),
                new Car("Honda", "Civic", 2019, Type.SEDAN),
                new Car("Ford", "Mustang", 2021, Type.COUPE),
                new Car("Chevrolet", "Malibu", 2018, Type.SEDAN),
                new Car("Nissan", "Altima", 2020, Type.SEDAN),
                new Car("BMW", "M3", 2022, Type.COUPE),
                new Car("Audi", "S7", 2021, Type.SEDAN),
                new Car("Jeep", "Grand Cherokee", 2019, Type.SUV),
                new Car("Ram", "1500", 2020, Type.TRUCK),
                new Car("Ford", "F-150", 2021, Type.TRUCK),
                new Car("BMW", "M5", 2025, Type.SEDAN)
        );

        // TODO: Filter on sedan cars
//        Predicate<Car> filter = c -> c.type.equals(Type.SEDAN);
        List<Car> filteredCarsOnSedan = cars.stream()
                .filter(c -> c.type.equals(Type.TRUCK))
                .toList();
        filteredCarsOnSedan.forEach(System.out::println);

        // TODO: Get car makes
        List<String> makeList = cars.stream()
                .map(c -> c.make)
                .distinct()
                .toList();
//                .forEach(System.out::println);
        makeList.forEach(System.out::println);

        // TODO: Show make, model, make, model etc.
        cars.stream()
                .map(c -> List.of(c.make, c.model))
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        // TODO: Count no of sedans
        long numOfSedan = cars.stream()
                .filter(c -> c.type.equals(Type.SEDAN))
                .count();
        System.out.println("Number of sedans: " + numOfSedan);

        // TODO: partioningBy SUVs
//        Map<Boolean, List<Car>> partition = cars.stream()
//                .collect(Collectors.partitioningBy(c -> c.type.equals(Type.SUV)));
//        System.out.println(partition);

        cars.stream()
                .collect(Collectors.partitioningBy(c -> c.type.equals(Type.SUV)))
                .forEach((a, b) -> System.out.println(a + "- " + b));

        // TODO: GroupBy type
//        Map<Type, List<Car>> group = cars.stream()
//                .collect(Collectors.groupingBy(c -> c.type));

        cars.stream()
                .collect(Collectors.groupingBy(c -> c.type))
                .forEach((a, b) -> System.out.println(a + "- " + b));

    }
}
