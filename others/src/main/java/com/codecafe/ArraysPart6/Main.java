package com.codecafe.ArraysPart6;

// Find the maximum and minimum value in the array
public class Main {
    public static void main(String[] args) {

        int[] arr = {3, 9, 2, 7, 6};

        int min = arr[0];
        int max = arr[0];

        for(int i = 0; i<arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }

            if(arr[i] < min){
                min = arr[i];
            }
        }

        System.out.println("Maximum value = " + max);
        System.out.println("Minimum value = " + min);
    }

}
