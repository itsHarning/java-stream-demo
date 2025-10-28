package ek.osnb.streamdemo;

import java.util.List;
import java.util.stream.Stream;

public class Streams03 {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // TODO: Reusable streams = NOOOOO!
        Stream<Integer> reusable = numbers.stream().filter(n -> n % 2 == 0);

        reusable.forEach(System.out::println);
//        List<Integer> myInts = reusable.toList();
    }
}
