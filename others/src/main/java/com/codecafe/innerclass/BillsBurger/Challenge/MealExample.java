package com.codecafe.innerclass.BillsBurger.Challenge;

public class MealExample {
    private double price = 5.0;
    private Item burger;
    private Item drink;
    private Item side;

    public MealExample(){

        burger = new Item("regular", "burger");
        drink = new Item("coke", "drink", 1.5);
        System.out.println(drink.name);
        side = new Item("fries", "side", 2.0);
    }

    private class Item {

        private String name;
        private String type;
        private double price;

        public Item(String name, String type) {
            // Error : price - Cannot reference "Item.price" before superclass constructor has been called.
            // Price field is declared both in outer class and inner class
            // If I reference price, without any qualifier in code, it refers to the price applicable
            // to the current scope.
            //so here constructor refers to Item class price and not Meal class price.
            // Problem :
            //this(name, type, type.equals("burger") ? price : 0);
           // solution :
            this(name, type, type.equals("burger") ? MealExample.this.price : 0);
        }

        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }
    }
}
