package com.codecafe.EncapsulationChallenge;

public class Main {
    public static void main(String[] args) {
        // Here, we are using encapsulation with this constructor.
        Printer printer = new Printer(-8, true);
        System.out.println("Initial page count = " + printer.getPagesPrinted());

       int printedPages = printer.printPages(5);
        System.out.println(printedPages + " " + printer.getPagesPrinted());

        int printedPages2 = printer.printPages(10);
        System.out.println(printedPages + " " + printer.getPagesPrinted());
    }
}
