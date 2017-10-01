package rtt.java9.code.sample.simple.diamond;

public class DiamondJava9 {

    interface Printable<T> {
        void print(T t);

        void printReverse(T t);
    }

    public static void main(String[] args) {
        DiamondJava8.Printable<Integer> printable = new DiamondJava8.Printable<>() {
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
