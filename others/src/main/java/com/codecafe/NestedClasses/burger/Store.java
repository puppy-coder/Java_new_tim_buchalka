package com.codecafe.NestedClasses.burger;

public class Store {

    public static void main(String[] args) {

        // This was demo of how you can use an inner class to build a composition inside of a
        // class, when it makes sense to do so. This meal class is very well encapsulated.
        Meal regularMeal = new Meal();
        System.out.println(regularMeal);

        // The Meal and Items are tightly coupled in this challenge, because bill sells meals
        // and not individual items

        // Create Meal in US Dollars
        Meal USRegularMeal = new Meal(0.68);
        System.out.println(USRegularMeal);

        // Note : In a real application, you would be using an online service to find the
        // current conversion rate at the time of the transaction.
        // But here , we will just hard code the rate from Australian dollars to US dollars as
        // 0.68. Means, one Australian dollar is equivalent to 68 US Cents.
        // $ 1 AUD = $ 0.68C
        // We will get output as regular meal as converted price!

        // Note: This is the example for using static method in nested classes.
        // Nested classes now include a nested interface, a static enum, or a static record to add lot
        // more functionalities to your inner classes!
    }
}
