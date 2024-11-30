package com.codecafe.CompositionChallenge;

public class Main {
    public static void main(String[] args) {

        SmartKitchen smartKitchen = new SmartKitchen();

      //  smartKitchen.getDishWasher().setHasWorkToDo(true);
        //smartKitchen.getBrewMaster().setHasWorkToDo(true);
       // smartKitchen.getIceBox().setHasWorkToDo(true);

       // smartKitchen.getBrewMaster().brewCoffee();
        //smartKitchen.getDishWasher().doDishes();
        //smartKitchen.getIceBox().orderFood();

        smartKitchen.setKitchenState(true, false, true);
        smartKitchen.doKitchenWork();
    }
}
