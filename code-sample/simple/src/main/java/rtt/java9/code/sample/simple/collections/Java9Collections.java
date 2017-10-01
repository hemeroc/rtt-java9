package rtt.java9.code.sample.simple.collections;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Java9Collections {

    private static final Map<String, Integer> constantMap =
        Map.of("timeout", 1500,
            "maxRetries", 3,
            "initialDelay", 5000
        );

    private static final Set<String> keys =
        Set.of("timeout", "maxRetries", "initialDelay");

    public static void main(String[] args) {
        List<String> selectKeys = List.of("timeout", "initialDelay");
        Set<String> intersection = new HashSet<>(keys);
        intersection.retainAll(selectKeys);
        for(String key : intersection) {
            System.out.println(key +  "=" + constantMap.get(key));
        }
    }

}
