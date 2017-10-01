package rtt.java9.code.sample.simple.collections;

import java.util.Map;

public class Java9Map {

    private static final Map<String, Integer> constantMap =
        Map.of("timeout", 1500,
            "maxRetries", 3,
            "initialDelay", 5000
        );

    public static void main(String[] args) {
        System.out.println("timeout=" + constantMap.get("timeout"));
        System.out.println("maxRetries=" + constantMap.get("maxRetries"));
        System.out.println("initialDelay=" + constantMap.get("initialDelay"));
    }

}
