package com.codecafe.ArraysPart3;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] firstArray = getRandomArray(10);
        System.out.println(Arrays.toString(firstArray));
        Arrays.sort(firstArray); // This sort method does not return anything. sort is the
        // void method
        System.out.println(Arrays.toString(firstArray));

        int[] secondArray = new int[10];
        System.out.println(Arrays.toString(secondArray));
        Arrays.fill(secondArray, 11);
        System.out.println(Arrays.toString(secondArray));

        int[] thirdArray = getRandomArray(10);
        System.out.println(Arrays.toString(thirdArray));

        int[] fourthArray = Arrays.copyOf(thirdArray, thirdArray.length);
        System.out.println(Arrays.toString(fourthArray));

        Arrays.sort(fourthArray);
        System.out.println(Arrays.toString(fourthArray));
        System.out.println(Arrays.toString(thirdArray));

        //An array copy creates a new array, a new instance of an array
        // and copies the array elements over to the new array

        // Performing operations on the copied array, like sort and fill,don't
        // impact the original array

        //Let's see what's happening, if we copy only few elements from the original Array
        int[] copiedArray = Arrays.copyOf(thirdArray, 5);
        System.out.println(Arrays.toString(copiedArray)); // It copied only 5 values

        //Let's see what's happening, if we copy more elements from the original array
        int[] largerArray = Arrays.copyOf(thirdArray, 15);
        System.out.println(Arrays.toString(largerArray)); // It automatically puts [0,0,0,0,0]
        // for the extra elements

        //Arrays.binarySearch
        String[] sArray = {"Able", "Jane", "Mark", "Ralph", "David"};
        Arrays.sort(sArray);
        // Binary Search only works on Sorted Array -> Important Note
        System.out.println(Arrays.toString(sArray));
        if(Arrays.binarySearch(sArray, "Mark") >=0){
            System.out.println("Found Mark in the list");
        }

        int[] s1 = {1,2,3,4,5};
        int[] s2 = {1,2,3,4,5};
        // int[] s3 = {1, 2,3,4,5,0} // Arrays not equal because length not matched

        if(Arrays.equals(s1, s2)){
            System.out.println("Arrays are equal");
        }
        else{
            System.out.println("Arrays are not equal");
        }

    }
    private static int[] getRandomArray(int len){
        Random random = new Random();
        int[] newInt = new int[len];
        for(int i = 0; i < len; i++){
            newInt[i] = random.nextInt(100);
        }

        return newInt;
    }
}
