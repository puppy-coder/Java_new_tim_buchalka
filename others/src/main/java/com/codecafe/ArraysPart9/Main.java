package com.codecafe.ArraysPart9;

import java.util.Arrays;

//Rotate Array by K Positions (Right Rotation)
// Input: {1, 2, 3, 4, 5}, k=2
// Output: {4, 5, 1, 2, 3}
public class Main {
    public static void main(String[] args) {

        // What "Right Rotation" by "K" means
        // Each element is shifted to the right by k steps
        // The elements that "fall off" the end come back around to the front
        // So K = 2, after first rotation
        //{1,2,3,4,5} ----------------> {5,1,2,3,4}
        // After second rotation
        // ----------------------> {4,5,1,2,3}

        //Index:   0  1  2  3  4
        //Array:  [1, 2, 3, 4, 5]
        //After right rotate by 2:
        //→ last 2 elements (4, 5) move to front
        //→ first 3 elements (1, 2, 3) move to back
        //Result: [4, 5, 1, 2, 3]

        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;
        int n = arr.length;

        // Step : 1 Handle if K is greater than array size. k > n
        k = k % n;

        // Step : 2 Create a new array
        int[] rotated = new int[n];

        // Step : 3 Copy last 'k' elements to front
        for(int i = 0; i < k ; i++){
            rotated[i] = arr[n - k + i];
            System.out.println(rotated[i]);
        }

        System.out.println(Arrays.toString(rotated));

        // Step : 4 Copy last n-k elements to front
        for(int i = 0; i < n-k; i++){
            rotated[k + i] = arr[i];
            System.out.println(rotated[i]);
        }
        System.out.println(Arrays.toString(rotated));

    }
}
