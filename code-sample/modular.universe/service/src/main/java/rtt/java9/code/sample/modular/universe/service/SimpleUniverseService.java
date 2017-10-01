package rtt.java9.code.sample.modular.universe.service;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

public class SimpleUniverseService implements UniverseService {

    private static final int SLEEP_SECONDS = 2;

    @Override
    public String calculateAnswer() {
        System.out.println("called calculateAnswer");
        // sleep to simulate heavy load
        try {
            System.out.println("Going to sleep for " + SLEEP_SECONDS + " seconds");
            Thread.sleep(Duration.of(SLEEP_SECONDS, SECONDS).toMillis());
        } catch (InterruptedException e) {
            System.out.println("Failed to sleep cause " + e.getMessage());
        }
        return "42!";
    }

}
