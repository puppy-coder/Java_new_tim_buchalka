package com.codecafe.ArraysPart8;

import java.util.Arrays;

// Reverse an array
public class Main {
    public static void main(String[] args) {

        int[] arr = {1, 11, 2, 3, 4, 5, 10};
        boolean isAscendingOrder = false;

        int[] reverse = new int[arr.length];
        for(int i = arr.length - 1, j=0; i>=0; i--, j++){
            reverse[j] = arr[i];
        }
        System.out.println(Arrays.toString(reverse));

        // Check if the Array is sorted in Ascending Order
        for (int i = 0, j = 1; i<arr.length-1;i++, j++){
            if(arr[i] < arr[j]){
                isAscendingOrder = true;
            }
            else{
                isAscendingOrder = false;
                break;

            }
        }

        System.out.println("Array is sorted in Ascending Order = " + isAscendingOrder );

    }
}
