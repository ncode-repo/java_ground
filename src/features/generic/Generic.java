package features.generic;

import features.Cat;

public class Generic {
    public static void main(String[] args) {
        Printer<Integer> printer = new Printer<>();
        printer.print(10);

        Printer<Cat> catPrinter = new Printer<>();
        catPrinter.print(new Cat());
    }
}
