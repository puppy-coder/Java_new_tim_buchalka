package com.codecafe.GenericBoundedTypeParameters;

public class Main {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        //integerBox.set(new Integer(10));
        //integerBox.inspect("some text"); // error: this is still String!
    }
}
