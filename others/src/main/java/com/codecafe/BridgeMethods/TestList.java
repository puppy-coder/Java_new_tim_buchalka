package com.codecafe.BridgeMethods;

import java.util.ArrayList;


public class TestList {
    public static void main(String[] args) {
        IntegerArrayList i = new IntegerArrayList();
        i.add(10);
    }
}

// Correct one
class IntegerArrayList extends ArrayList<Integer> {
    @Override
    public boolean add(Integer integer) {
        return true;
    }
}

class MyArrayList<T> extends ArrayList<T> {

}

