package rtt.java9.code.sample.simple.interfaces;

interface Calculator {

    private static int fancyCalculation() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 42;
    }

    default int calculate() {
        return fancyCalculation();
    }

}
