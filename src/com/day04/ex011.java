package com.day04;

/*
    Реализовать волновой алгоритм
 */

import java.util.Random;

public class ex011 {
    public static void main(String[] args) {
        int[][] map = new int[15][20];
        makeMap(map);
        int startPointX = 5;
        int startPointY = 5;
        map[startPointX][startPointY] = 0;
        makeWaves(map, startPointX, startPointY, 0);
        showMap(map);
    }

    public static void makeMap(int[][] map) {
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            map[random.nextInt(15)][random.nextInt(20)] = -1;
        }
    }

    public static void makeWaves(int[][] map, int pointX, int pointY, int count) {
        if (pointX < 0 || pointX == map.length || pointY < 0 || pointY == map[0].length) return;
        map[pointX][pointY] = map[pointX][pointY] != -1 ? count : -1;
        makeWaves(map, pointX - 1, pointY, count + 1);
        makeWaves(map, pointX, pointY - 1, count + 1);
    }

    public static void showMap(int[][] map) {
        for (int[] i : map) {
            for (int j : i) {
                System.out.printf("%3d", j);
            }
            System.out.println(" ");
        }
    }
}
