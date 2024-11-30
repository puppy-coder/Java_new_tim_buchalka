package com.codecafe.Encapsulation;

public class Main {
    public static void main(String[] args) {
        EnhancedPlayer enhancedPlayer = new EnhancedPlayer("Dhana", 200, "Sword");
        // Even though we passed 200
        // Output is still 100.
        //This is encapsulation
        //There is no other way for the calling code to change the health, except the call
        // to enhanced player methods to do it.
        //This gives all the control to the enhanced player class

        //Also the calling code has no idea what the internal naming was, for the fields
        System.out.println("Initial health is " + enhancedPlayer.healthRemaining());
    }
}
