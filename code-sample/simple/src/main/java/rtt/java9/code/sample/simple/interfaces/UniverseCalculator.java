package rtt.java9.code.sample.simple.interfaces;

public class UniverseCalculator implements Calculator {

    public static void main(String[] args) {
        UniverseCalculator universeCalculator = new UniverseCalculator();
        System.out.println("Calculated: " + universeCalculator.calculate());
    }

}
