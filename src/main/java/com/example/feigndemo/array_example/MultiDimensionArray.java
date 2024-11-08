package com.example.feigndemo.array_example;

public class MultiDimensionArray {

    public static void main(String[] args) {
        int[][] multiArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int[] row : multiArray) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        String array [][] = new String[2][2];
        array[0][0] = "set";
        for (String[] row : array) {
            for (String element: row) {
                System.out.println(element + "");
            }
            System.out.println();
        }
    }
}
