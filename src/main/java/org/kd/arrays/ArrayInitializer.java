package org.kd.arrays;

import java.util.Arrays;


public class ArrayInitializer {

    static int[] initializeArrayInLoop() {
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 2;
        }
        return array;
    }

    static int[][] initializeMultiDimensionalArrayInLoop() {
        int[][] array = new int[2][5];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                array[i][j] = j + 1;
            }
        }

        return array;
    }

    static String[] initializeArrayAtTimeOfDeclarationMethod1() {
        return new String[]{"Toyota", "Mercedes", "BMW", "Volkswagen", "Skoda"};
    }

    static int[] initializeArrayAtTimeOfDeclarationMethod2() {
        return new int[]{1, 2, 3, 4, 5};
    }

    static int[] initializeArrayAtTimeOfDeclarationMethod3() {
        return new int[]{1, 2, 3, 4, 5};
    }

    static long[] initializeArrayUsingArraysFill() {
        long[] array = new long[5];
        Arrays.fill(array, 30);
        return array;
    }

    public static int[] initializeArrayRangeUsingArraysFill() {
        int[] array = new int[5];
        Arrays.fill(array, 0, 3, -50);
        return array;
    }

    static int[] initializeArrayUsingArraysCopy() {
        int[] array = {1, 2, 3, 4, 5};
        return Arrays.copyOf(array, 5);
    }

    static int[] initializeLargerArrayUsingArraysCopy() {
        int[] array = {1, 2, 3, 4, 5};
        return Arrays.copyOf(array, 6);
    }

    public static int[] initializeArrayUsingArraysSetAll() {
        int[] array = new int[5];

        Arrays.setAll(array, p -> p >= 3 ? 0 : p);
        return array;
    }

}
