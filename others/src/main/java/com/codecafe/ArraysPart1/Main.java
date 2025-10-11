package com.codecafe.ArraysPart1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        int[] myIntArray = new int[10];
        myIntArray[5] = 50; // Assigning value 50 to the 5th position of an array!

        double[] myDoubleArray = new double[10];
        myDoubleArray[3] = 3.5;
        System.out.println(myDoubleArray[3]);

        //Array Initializer
        int[] firstTen = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("First : " + firstTen[0]);
        int arrayLength = firstTen.length;
        System.out.println(arrayLength);
       // System.out.println("Last Element : " + firstTen[arrayLength]);// Index Out of Bounds Error for length 10
        System.out.println("Last Element : " + firstTen[arrayLength - 1]);

        int[] newArray;
        // Array Initializer in Separate Line
        //newArray = {3, 4, 7, 8, 9}; // Array Initializer is not allowed here

        newArray = new int[] {3, 4, 6, 7, 8}; // but this is allowed
        for(int i = 0; i < newArray.length; i++){
            System.out.print(newArray[i] + " ");
        }
        System.out.println();

        int[] oldArray;
        oldArray = new int[5];
        for(int i = 0; i < oldArray.length; i++){
            System.out.print(oldArray[i] + " ");
        }

        System.out.println();
        for(int element : newArray){
            System.out.print(element + " ");
        }

        System.out.println();
        System.out.println(newArray);
        System.out.println(oldArray);

        System.out.println(oldArray.getClass());
        System.out.println(Arrays.toString(newArray));

        Object obj = newArray;
        if(obj instanceof int[]){
            System.out.println("Obj is really an int array");
        }

        Object[] objectArray = new Object[3];
        objectArray[0] = "Hello";
        objectArray[1] = new StringBuilder("World");
        // Array can be treated like any other object instance in Java : Important

    }
}
