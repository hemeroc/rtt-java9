package rtt.java9.code.sample.simple.optional;

import java.util.Optional;

public class ImprovedOptionals {

    public static void main(String[] args) {
        Optional.empty().ifPresentOrElse(
            present -> System.out.println("Optional contained " + present),
            () -> System.out.println("Optional was empty")
        );
        Optional.of("HelloWorld").ifPresentOrElse(
            present -> System.out.println("Optional contained " + present),
            () -> System.out.println("Optional was empty")
        );
    }

}
