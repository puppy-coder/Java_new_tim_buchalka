package com.codecafe.GenericMethods;

public class Main {
    public static void main(String[] args) {
        //The complete syntax for invoking this method would be:

        Pair<Integer, String> p1 = new Pair<>(1, "apple");
        Pair<Integer, String> p2 = new Pair<>(2, "pear");

        //The type has been explicitly provided
        boolean same = Util.<Integer, String>compare(p1, p2);

        //Generally, this can be left out and the compiler will infer the type that is needed:

        Pair<Integer, String> p11 = new Pair<>(1, "apple");
        Pair<Integer, String> p21 = new Pair<>(2, "pear");
        boolean same1 = Util.compare(p1, p2);

        //This feature, known as type inference, allows you to invoke a generic method
        //as an ordinary method, without specifying a type between angle brackets.
    }
}
