package com.codecafe.Lambdas;

import java.util.function.*;

//We have a look at functional interfaces from API
public class Functional_Interfaces_From_API {

    public static void main(String[] args) {
        Functional_Interfaces_From_API fi = new Functional_Interfaces_From_API();
    }
    //Important : Predicate - Accepts something return boolean
    public void predicate(){
        // Predicate<T> is a functional interface i.e. one abstract method
        // boolean test(T t)
        Predicate<String> pStr = s -> s.contains("City");
        System.out.println(pStr.test("Vatican City")); //true

        //BiPredicate<T, U> is a functional interface i.e. one abstract method:
        // It defines two generic markers (T and U)
        // boolean test(T t, U u);
        BiPredicate<String, Integer> checkLength = (str, len) -> str.length() == len;
        System.out.println(checkLength.test("Vatican City", 8)); //false (length is 12);

    }
}
//Key Concepts:
//Functional Interfaces:
//
//An interface with a single abstract method (SAM).
//Used extensively in Java's functional programming paradigm.
//Predicate:
//
//Takes one input and returns a boolean.
//Example: Predicate<String> isEmpty = s -> s.isEmpty();
//BiPredicate:
//
//Takes two inputs and returns a boolean.
//Example: BiPredicate<String, Integer> isLengthMatch = (str, len) -> str.length() == len;
//Lambda Expressions:
//
//Compact way of implementing functional interfaces.
//Syntax: (parameters) -> {body}.