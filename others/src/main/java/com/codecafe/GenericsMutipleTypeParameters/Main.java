package com.codecafe.GenericsMutipleTypeParameters;

public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
        Pair<String, String> p2 = new OrderedPair<String, String>("Hello", "World");

       // The code, new OrderedPair<String, Integer>, instantiates K as a String and V as an Integer.
        // Therefore, the parameter types of OrderedPair's constructor are String and Integer,
        // respectively. Due to autoboxing, it is valid to pass a String and an int to the class.

        OrderedPair<String, Integer> p3 = new OrderedPair<>("Even", 8);
        OrderedPair<String, String>  p4 = new OrderedPair<>("hello", "world");

        //Java compiler can infer the K and V types from the declaration OrderedPair<String, Integer>,
        // these statements can be shortened using diamond notation


        //You can also substitute a type parameter (that is, K or V) with a parameterized type
        // (that is, List<String>). For example, using the OrderedPair<K, V> example:

        //OrderedPair<String, Box<Integer>> p = new OrderedPair<>("primes", new Box<Integer>(...));
    }
}
