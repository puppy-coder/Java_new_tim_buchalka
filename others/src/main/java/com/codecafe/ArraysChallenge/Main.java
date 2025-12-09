package com.codecafe.ArraysChallenge;

import java.util.Arrays;
import java.util.Random;

// Sort the list of integers in descending order
public class Main {
    public static void main(String[] args) {

        // Method 1
        int[] arr = {50, 25, 80, 5, 15};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int[] dsorted = new int[arr.length];

        for(int i = arr.length-1, j = 0; i >= 0; i--, j++){
            dsorted[i] = arr[j];
        }
        System.out.println(Arrays.toString(dsorted));

        int[] unsortedArray = getRandomArray(5);
        System.out.println(Arrays.toString(unsortedArray));

        int[] sortedArray = sortIntegers(new int[] {7, 30, 35});
        System.out.println(Arrays.toString(sortedArray));
    }
    // Method 2
    public static int[] getRandomArray(int len){
        Random random = new Random();
        int[] randomArray = new int[len];
        for(int i = 0; i < randomArray.length; i++){
            randomArray[i] = random.nextInt(1000);
        }

        return randomArray;
    }

    public static int[] sortIntegers(int[] array){
        System.out.println(Arrays.toString(array));
        int[] sortedArray = Arrays.copyOf(array, array.length);
        boolean flag = true;
        int temp;
        while(flag){
            flag = false;
            for(int i = 0; i < sortedArray.length - 1; i++){
                if(sortedArray[i] < sortedArray[i + 1]){
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                    System.out.println("------>" + Arrays.toString(sortedArray));
                }
                System.out.println("------>" + Arrays.toString(sortedArray));

            }
        }
        return sortedArray;
    }
}
