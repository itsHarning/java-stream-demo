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

        // TODO: Show make, model, make, model etc.

        // TODO: Count no of sedans

        // TODO: partioningBy SUVs

        // TODO: GroupBy type

    }
}
