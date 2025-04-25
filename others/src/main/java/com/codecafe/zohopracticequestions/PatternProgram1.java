package com.codecafe.zohopracticequestions;

public class PatternProgram1 {
    public static void main(String[] args) {

        String word = "PROGRAM";
        int length = word.length();

        // looping through the row
        for(int i = 0; i < length; i++){
            for(int j = 0; j< length; j++){
                if(j == i || j == length - 1 - i){
                    System.out.print(word.charAt(j));
                }
                else{
                    System.out.print(" ");
                }
            }

            // Move to the next line
            System.out.println();
        }
    }
}

/*
if (j == i || j == length - i - 1)
j == i: This condition is true for the left diagonal.

For example:
When i = 0, j = 0.
When i = 1, j = 1.
When i = 2, j = 2.
And so on.

j == length - i - 1: This condition is true for the right diagonal.

For example:
When i = 0, j = 6 (last column).
When i = 1, j = 5 (second last column).
When i = 2, j = 4, and so on.
*/

/*
At the end of each row (i), the program moves to the next line using:
System.out.println();
This ensures that the next row of the pattern starts on a new line.
 */