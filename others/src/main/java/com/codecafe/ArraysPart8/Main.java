package com.codecafe.ArraysPart8;

import java.util.Arrays;

// Reverse an array
public class Main {
    public static void main(String[] args) {

        int[] arr = {12, 13, 14, 1, 2, 3, 4, 5, 10, 11, 15};
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

        //Find the second largest element in the array
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length;i++){
            if(arr[i] > largest){
                secondLargest = largest;

                largest = arr[i];
            }
            // handle the case when an element is less than largest but greater than secondLargest.
            if(arr[i] > secondLargest && arr[i] != largest){
                secondLargest = arr[i];
            }
        }
        System.out.println("Largest Number = " + largest);
        System.out.println("Second Largest number = " + secondLargest);

    }
}
