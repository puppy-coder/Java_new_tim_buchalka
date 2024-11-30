package com.codecafe.innerclass.BillsBurger.Challenge;


//This code represents a Meal class that contains a private inner class called Item.
// The Meal class is designed to represent a meal that consists of a burger, a drink,
// and a side. Each of these is represented by an instance of the Item class
public class Meal {

    //It represents the base price for a regular burger.
    private double base = 5.0;
    //Each is an instance of the inner class Item representing different components of the meal.
    private Item burger;
    private Item drink;
    private Item side;

    //This constructor constructs a regular meal, with a regular burger, a coke and a side of fries.
    public Meal(){
        //Initializes the burger, drink, and side with specific values:
                //A regular burger (base price).
        burger = new Item("regular", "burger");
                //A drink (coke) priced at 1.5.
        drink = new Item ("coke", "drink", 1.5);

        //Prints the name of the drink to demonstrate access to inner class fields.
        System.out.println(drink.name);
                //A side (fries) priced at 2.0.
        side = new Item("fries", "side", 2.0);
    }

    //Note : So the meal, using an inner class item to represent
    //everything in a meal

    @Override
    public String toString(){
        return "%s%n%s%n%s%n".formatted(burger, drink, side);
    }


    private class Item{

        private String name;
        private String type;
        private double price;

        //Constructor Overloading:
        //The two constructors in Item demonstrate overloading:
        //The other provides a default price based on the type, delegating to the primary constructor using this(...).
        public Item(String name, String type){
            //Here, I am assigning the base price, a private field on the enclosing meal class
            // directly to an attribute on an instance of Item, if it's a burger.
            //This is an example showing that the inner class has direct access to the
            //outer class's attributes, even private ones.
            //The inner class (Item) can directly access the outer class’s private field (base) without needing a getter.
            // This is a feature of Java's inner classes.

            //The base field is private to the Meal class but is accessible to the inner Item class,
            //showcasing encapsulation and the special
            //relationship between an outer class and its inner class.

            //The Item class is a private inner class, meaning it is accessible only within the Meal class.
            // It is used to encapsulate details about individual items in the meal.
            this(name, type, type.equals("burger") ? base : 0);
        }

        //One initializes all fields directly.
        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString(){
            return "%10s%15s $%.2f".formatted(type, name, price);
        }
    }
}

//Advantages of Design :
//Encapsulation:
//The Item class is hidden within the Meal class, limiting its scope and preventing misuse outside the context of a Meal.

//Reusability:
//The Item class can represent any part of the meal with minimal changes, making the design flexible and scalable.

//Code Reuse:
//Constructor overloading and delegation (this(...)) reduce duplication, centralizing logic for price assignment.

//Potential Use Case:
//This design could be part of an application for a restaurant where meals are dynamically
// created with specific items. For example:

//A regular burger meal with default components.
//A customizable meal with different items or prices.
