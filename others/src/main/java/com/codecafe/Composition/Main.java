package com.codecafe.Composition;

public class Main {
    public static void main(String[] args) {
        ComputerCase computerCase = new ComputerCase("2208", "Dell",
                "240");
        Monitor monitor = new Monitor("27inch Beast", "Acer",
                27, "2540 * 1440");
        Motherboard motherboard = new Motherboard("BJ-200", "Asus", 4, 6,
                "v2.44");
        PersonalComputer thePC = new PersonalComputer("2208", "Dell",
                computerCase, monitor, motherboard);

        //Method 1
        //-- Important! - Breaking the Abstraction
        //Examples:
        //1. Grow method in arraylist
        //2. Json parser library
        //Note: whenever we are creating the library, then only we can do all these oops
        //concepts in reality, because we are going to expose that library outside

        // thePC.getMonitor().drawPixelAt(200, 100, "blue");
        // thePC.getMotherboard().loadProgram("Windows OS");
        // thePC.getComputerCase().pressPowerButton();

        //Method 2 - Hide the functionality. Not allow the calling function to access objects/parts directly

        thePC.powerUp();
    }
}