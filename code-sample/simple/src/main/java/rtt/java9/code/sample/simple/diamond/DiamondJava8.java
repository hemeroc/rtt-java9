package rtt.java9.code.sample.simple.diamond;

public class DiamondJava8 {

    interface Printable<T> {
        void print(T t);

        void printReverse(T t);
    }

    public static void main(String[] args) {
        Printable<Integer> printable = new Printable<Integer>() {
            @Override
            public void print(Integer o) {
                System.out.println(o.toString());
            }

            @Override
            public void printReverse(Integer o) {
                System.out.println(
                    new StringBuilder(o.toString())
                        .reverse().toString());
            }
        };
        printable.print(12345);
        printable.printReverse(12345);
    }

}
