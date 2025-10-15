package com.codecafe.ArraysPart2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] newArray;
        newArray = new int[5];

        for(int i = 0; i < newArray.length; i++){ // Initializing array through loop
            newArray[i] = newArray.length - i;
            System.out.println(newArray[i]);
        }

        for(int i =0; i < newArray.length; i++){
            System.out.print(newArray[i] + " "); // Output : 0 0 0 0 0
        }
        System.out.println();
        // for each loop
        for (int element : newArray){
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println(newArray); // calling toString() method
        System.out.println();
        System.out.println(Arrays.toString(newArray)); // Output : [5, 4, 3, 2, 1]

        Object[] obj = new Object[3];
        obj[0] = "Hello";
        obj[1] = new StringBuilder("World");
        obj[3] = newArray; // Assigning array of integers

        int a2[] = new int[5];



    }
}
