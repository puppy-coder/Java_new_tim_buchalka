package com.codecafe.ArraysPart4;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Custom Formatting of arrays
        // Manual Code

        int[] arr = {1, 2, 3};
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < arr.length;i++){
            builder.append(arr[i]);
            if(i < arr.length - 1){
                builder.append(" | ");
            }
        }

        System.out.println(builder);

        //Using Streams
        String s = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" | "));

        System.out.println(s);
        //The Stream version is concise, functional and readable

        // Expected Output : 1 | 2 | 3
    }
}
