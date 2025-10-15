package com.codecafe.ArraysPart7;

// Count even and odd numbers
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 11};

        int even = 0;
        int odd = 0;

        for(int i = 0; i<arr.length;i++){
            if(arr[i] % 2 == 0){
                even = even + 1;
            }
            else{
                odd = odd + 1;
            }
        }
        System.out.println("Even " + even);
        System.out.println("Odd " + odd);

    }
}
