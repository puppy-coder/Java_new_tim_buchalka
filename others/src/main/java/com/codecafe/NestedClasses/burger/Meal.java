package com.codecafe.NestedClasses.burger;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    private double price = 5.0;
    // burger, drink and side variables using the "Item" as their variable type.
    // Item being the inner class.
    // Important we already know: One bonus is for nested classes is that both the inner class
    // and the outer class have direct access to the other's instance members.
    private Burger burger;
    private Item drink;
    private Item side;

    private double conversionRate;

    public Meal(){
        this(1); // Chains a call to the other constructor.
        // Passing 1 as the conversion rate, which means there is no conversion, multiplying
        // any number by 1 returns the same value.
    }

    // This constructor constructs a regular meal, with a regular burger, a coke and a
    // side of fries
    public Meal(double conversionRate){
        this.conversionRate = conversionRate;
        burger = new Burger ("regular");
        drink = new Item ("coke", "drink", 1.5);
        System.out.println(drink.name);
        side = new Item ("fries", "side", 2.0);
    }

    public double getTotal(){
        // Getting error on burger.price in the Meal Class. Burger is an inner class on Meal.
        // why isn't its price visible to Meal?
        // Burger inherited Price field from Item and although Item's price is available to Meal
        // through the Item class, it's not accessible as an inherited field on burger.
        // The rules of inheritance are still in place, even within the inner class structure.
        // The easiest way to get around this is to create a getter, on the burger class.
        //double total = burger.price + drink.price + side.price;
        // Error : "price" has private access in "com.codecafe.NestedClasses.burger.Meal.Item"
        double total = burger.getPrice() + drink.price + side.price;
        return Item.getPrice(total, conversionRate);
        // This time I use Item class name to call static method getPrice,
        // because this code is outside the Item class
    }

    @Override
    public String toString(){
        return "%s%n%s%n%s%n%26s$%.2f".formatted(burger, drink, side, "Total Due: ",
                getTotal());
    }

    // Private Inner Class
    // It's not declared as static, and it's declared as a class member
    private class Item{

        private String name;
        private String type;
        private double price;

        public Item(String name, String type){
            // Here, we are assigning the base price, a private field on the enclosing
            // Meal class, directly to an attribute on an instance of Item, if it's a burger.
            // This is the example showing that the inner class has direct access to the outer
            // class's attributes, even private ones.
            //this(name, type, type.equals("burger") ? price : 0);
            this(name, type, type.equals("burger") ? Meal.this.price : 0);
            // Calls another constructor within the same class
            //price error : Cannot reference "item.price" before supertype constructor has been
            // called - //this(name, type, type.equals("burger") ? price : 0);
            // what's going on here?
            // We have got a price field on Meal, and we have also got a price field on Item.
            // If I reference price, without any qualifier in the code, it refers to price
            // applicable to the current scope.
            // In this example, I'm in the Item class, so price here in the constructor refers
            // to Item's price, and not Meal's price.
            // How do I tell it to use Meal's price and not Item's price?
            // Meal.this.price => This code compiles fine!!!!
        }

        public Item(String name, String type, double price){
            this.name = name;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString()
        {
            return "%10s%15s $%.2f".formatted(type, name, getPrice(price, conversionRate));
        }

        // After jDk, 16
        // I want to add a Static method on Item, that will convert my prices,
        // in Australian dollars, to US Dollars, since, Bills burger chains are opening
        // up in the US.
        // This method will take any price and any conversion rate and return a
        // converted price. It can be static, since the variables needed are all
        // passed as arguments.

        private static double getPrice(double price, double rate){
            return price * rate;
        }
    }

    // Private and non - static inner class
    // Any access to this class, and its functionality has to go through the Meal
    // class in other words
    // This Burger class extends Item, so I don't need to include name, type or price as
    // field. But we need a constructor
    private class Burger extends Item{

        // Prior to the JDK 16 release, this wouldn't have compiled, because you couldn't include
        // static members, other than a static constant variable, in an inner class.
        // Why I am saying this is static?
        // Let me add the static keyword here
        // Notice that intelliJ has greyed it out
        // Warning : Modifier Static is redundant for inner enums
        // It's also redundant for interfaces and records.
        // These types are implicitly static when used as inner types.
        // static enum Extra
        // Changing this enum from static to private because this enum won't be used by the client
        // code. It's for internal use only. Internal to the burger class.

        private enum Extra
        {
            AVOCADO,
            BACON,
            CHEESE,
            KETCHUP,
            MAYO,
            MUSTARD,
            PICKLES;

            // You only need semicolon if you are including extra code in the enum.
            private double getPrice(){
                return switch (this){ // Notice, I am switching on the keywords "this".When the getPrice
                    // method gets called, it will be called from an instance of one of the enum extra constants.
                    // So I can use this as my switch expression
                    case AVOCADO -> 1.0;
                    case BACON, CHEESE -> 1.5; // When you switch on an enum, you use enum constants
                    // in the case labels.
                    default -> 0;
                };
            }

        }

        // Toppings are just instances of Items
        private List<Item> toppings = new ArrayList<>();

        // I am not declaring access modifier here, meaning I am making it package private here.
        // As long as I don't subclass Burger, this modifier's access is restrictive as I can make it.
        Burger(String name){
            super(name, "burger", 5.0);
        }

        // Getter to get price from Item.
        // Note : This would not work if item was not an inner class of Meal, because price is
        // private on Item, but this takes advantage of the fact that Meal can access Item's price.
        public double getPrice(){
            return super.price;
        }

        // This is a private method and doesn't return anything
        private void addToppings(String... selectedToppings) // Var args method parameter
        {
            for(String selectedTopping : selectedToppings){
                // The valueOf method on the enum, lets us get an enum constant, by the constant name.
                // I take the varargs String Passed on the method, making it all upper case, then see
                // If I can find match to that name, in my Extras enum.
                Extra topping = Extra.valueOf(selectedTopping.toUpperCase());
                // Then I add a new Topping instance to my toppings list on burger.
                toppings.add(new Item(topping.name(), "TOPPING", topping.getPrice()));
                // topping.getPrice() - complies without issue, but are you wondering why?
                // Why can I access a private method on the enum from this code?
                // Again , this has to do with the special nature of inner types.
                // This code is actually buggy, because what happens if an item isn't found on the enum?

            }
        }

    }
}
