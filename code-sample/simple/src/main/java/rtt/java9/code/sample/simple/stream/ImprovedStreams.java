package rtt.java9.code.sample.simple.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ImprovedStreams {

    public static void main(String[] args) {
        System.out.println("Take while");
        IntStream.range(1, 11)
            .takeWhile(i -> i <= 5)
            .forEach(System.out::println);
        System.out.println("Drop while");
        IntStream.range(1, 10)
            .dropWhile(i -> i <= 5)
            .forEach(System.out::println);
        System.out.println("Iterate");
        Stream.iterate(1, i -> i <= 10, i -> 2 * i)
            .forEach(System.out::println);
    }
}
