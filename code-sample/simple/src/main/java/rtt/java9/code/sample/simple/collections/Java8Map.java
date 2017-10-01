package rtt.java9.code.sample.simple.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Java8Map {

    private static final Map<String, Integer> constantMap;

    static {
        final Map<String, Integer> realMap = new HashMap<>();
        realMap.put("timeout", 1500);
        realMap.put("maxRetries", 3);
        realMap.put("initialDelay", 5000);
        constantMap = Collections.unmodifiableMap(realMap);
    }

    public static void main(String[] args) {
        System.out.println("timeout=" + constantMap.get("timeout"));
        System.out.println("maxRetries=" + constantMap.get("maxRetries"));
        System.out.println("initialDelay=" + constantMap.get("initialDelay"));
    }

}
