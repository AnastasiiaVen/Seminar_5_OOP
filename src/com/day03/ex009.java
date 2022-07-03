package com.day03;

/*
    Реализовать алгоритм пирамидальной сортировки (HeapSort)
 */

import java.util.Arrays;

public class ex009 {
    public static void main(String[] args) {
        int[] initArray = new int[]{17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64};
        System.out.println(Arrays.toString(initArray));
        System.out.println(Arrays.toString(buildPyramid(initArray)));
    }

    public static int[] buildPyramid(int[] pyramid) {
        int maxIndex = 0;
        for (int i = pyramid.length / 2 - 1; i >= 0; i--) {
            if (i * 2 + 2 <= pyramid.length - 1) {
                if (pyramid[i * 2 + 2] > pyramid[i * 2 + 1]) maxIndex = i * 2 + 2;
                else maxIndex = i * 2 + 1;
            } else maxIndex = i * 2 + 1;
            if (pyramid[i] < pyramid[maxIndex]) {
                int temp = pyramid[i];
                pyramid[i] = pyramid[maxIndex];
                pyramid[maxIndex] = temp;
            }
            System.out.println(Arrays.toString(pyramid));
        }
        return pyramid;
    }

    public static int[] heapSort(int[] sortArray) {
        return sortArray;
    }
}
