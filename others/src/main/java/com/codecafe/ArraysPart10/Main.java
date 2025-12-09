package com.codecafe.ArraysPart10;

import java.util.Arrays;

// Remove duplicates from the int array
public class Main {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 1, 4};

        // Unique is a temporary array sized the same as 'a'. It will store the unique
        // values as we find them.
        // UniqueCount keeps how many unique values have been written into unique. It
        // also defines the active (filled) portion of unique
        int[] unique = new int[a.length];
        int uniqueCount = 0;

        for(int i = 0; i<a.length; i++) {
            boolean isDuplicate = false;

            for(int j = 0; j < uniqueCount; j++){
                if (a[i] == unique[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                unique[uniqueCount] = a[i];
                uniqueCount++;
            }



        }
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(unique[i] + " ");
        }


    }
}
