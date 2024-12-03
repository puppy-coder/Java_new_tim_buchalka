package com.codecafe.Lambdas;


import java.util.function.Predicate;

//This code demonstrates the use of both a custom functional interface (Evaluate<T>) and the standard
// Java Predicate<T> functional interface


//my own custom Functional Interface
interface Evaluate<T> {
    boolean isNegative(T t);
}
public class TestPredicate {
    public static void main(String[] args) {
        // Evaluate<T> is a functional interface i.e. one abstract method
        // boolean isNegative(T t); // similar to java.util.function.Predicate
        //Evaluate<Integer> lambda = i -> i < 0;
        Evaluate<Integer> lambda = i -> {
            return i < 0;
        }; //Implements IsNegative method
        System.out.println("Evaluate: " + lambda.isNegative(-1)); // true
        System.out.println("Evaluate: " + lambda.isNegative(1)); //false

        //here we are using standard Predicate<T> interface from java.util.function.
        //The predicate interface also has a single abstract method called test(T t), which is
        //equivalent to the isNegative(T t) method in your custom interface.

        Predicate<Integer> predicate = i -> i < 0;
        System.out.println("Predicate: " + predicate.test(-1)); //true
        System.out.println("Predicate: " + predicate.test(1)); //false

        //Both interfaces serve similar purposes, i.e., they evaluate a condition and return a boolean
        // result based on the input. However, the main difference is that Evaluate<T> is a custom interface,
        // while Predicate<T> is a standard interface provided by Java in the java.util.function package.

        //If you're using Java 8 or later, you often prefer using Predicate<T> as it's part of the standard
        // library and provides additional utility methods (e.g., and(), or(), negate()).

        //The code demonstrates the use of functional programming  concepts in Java, particularly the use of
        //lambdas and the predicate functional interface.

        int x = 4;
        //The check method is called with an integer (4 or 7) and a lambda expression (n -> n % 2 == 0).
        System.out.println("Is " + x + " even? " + check(4, n -> n % 2 == 0)); //true
        x = 7;
        System.out.println("Is " + x + " even? " + check(7, y -> y % 2 == 0)); // false

        String name = "Mr. Joe Bloggs";
        //The check method is called with a string and a lambda expression (s -> s.startsWith("Mr.")).
        System.out.println("Does " + name + " start with Mr. ? " +
                check("Mr. Joe Bloggs", s -> s.startsWith("Mr."))); //true
        name = "Ms. Ann Bloggs";
        System.out.println("Does " + name + " start with Mr. ?" +
                check("Ms. Ann Bloggs", s -> s.startsWith("Mr."))); //false
    }

    // The method is generic, meaning it can accept arguments of any type (T)

    //Parameters :
    //T t: The value to be tested (e.g., 4, "Mr. Joe Bloggs").

    //Predicate<T> lambda: A functional interface that takes a value of type T
    // and returns a boolean after applying its logic.

    //It uses the test method of the Predicate interface to evaluate the provided value
    // (t) based on the logic defined in the lambda expression (lambda).
        public static <T> boolean check(T t, Predicate<T> lambda){
        return lambda.test(t);
    }
}
