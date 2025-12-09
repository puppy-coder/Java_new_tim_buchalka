package com.codecafe.Arrayreferences;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] myIntArray = new int[5];
        int[] anotherArray = myIntArray; // Assigning one reference to another
        // Both variables are holding the same address

        System.out.println("myIntArray" + Arrays.toString(myIntArray));
        System.out.println("anotherArray" + Arrays.toString(anotherArray));

        anotherArray[0] = 1;
        modifyArray(myIntArray);

        System.out.println("After change in myIntArray" + Arrays.toString(myIntArray));
        System.out.println("After change in anotherArray" + Arrays.toString(anotherArray));

        // Output : myIntArray -> [1, 0, 0, 0, 0]
        //         anotherArray -> [1, 0, 0, 0, 0]
        // Both variables are referencing the same array in the memory. so there is
        // only one copy of the array
        // When you use one reference variable to make changes to the object in the memory,
        // it's like making that change with the other variable


    }

    private static void modifyArray(int[] array){
        array[1] = 2;
    }
}
