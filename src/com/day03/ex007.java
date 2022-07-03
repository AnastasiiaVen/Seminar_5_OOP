package com.day03;

/*
    На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
 */

import java.util.Arrays;

public class ex007 {
    public static void main(String[] args) {
        // Массив с координатами ферзей: строка, стобец, диагональ 1, диагональ 2
        // заполнен значениями вне возможного диапазона (доска 8х8)
        int[][] positions = {{9, 9, 16, 16}, {9, 9, 16, 16}, {9, 9, 16, 16}, {9, 9, 16, 16},
                {9, 9, 16, 16}, {9, 9, 16, 16}, {9, 9, 16, 16}, {9, 9, 16, 16}};

        setQueen(7, positions);
    }

    public static void setQueen(int queen, int[][] positions) {
        // Если расставлены все фигуры
        if (queen < 0) {
            showSolution(positions);
            return;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // По заданным индексам строк и столбцов находим диагонали
                int[] tempDiagonals = setDiagonals(i, j);
                // Если позиция свободна, устанавливаем фигуру
                if (positionIsEmpty(i, j, tempDiagonals[0], tempDiagonals[1], positions)) {
                    positions[queen] = new int[]{i, j, tempDiagonals[0], tempDiagonals[1]};
                    // Рекурсивно для остальных фигур
                    setQueen(queen - 1, positions);
                    // Для отображения всех возможных выариантов удаляем последнюю фигуру
                    positions[queen] = new int[]{9, 9, 16, 16};
                }
            }
        }
    }

    public static boolean positionIsEmpty(int row, int column, int diagonalX,
                                          int diagonalY, int[][] checkArray) {
        for (int[] i : checkArray) {
            // Проверяем свободны ли строка и столбец
            if (i[0] == row || i[1] == column) return false;
            // Проверяем свободны ли диагонали
            if (i[2] == diagonalX || i[3] == diagonalY) return false;
        }
        return true;
    }

    public static int[] setDiagonals(int row, int column) {
        /*
        Для вычисления номера диагоналей:
        для строки i = 0 и столбца j первый ряд диагоналей №№ 7 6 5 4 3 2 1 0 то есть (i + 7) - j
                                   и второй ряд диагоналей №№ 14 13 12 11 10 9 8 7 то есть (7 * 2 - i) - j
         */
        return new int[]{row + 7 - column, 7 * 2 - row - column};
    }

    public static void showSolution(int[][] arrayToShow) {
        int count = 1;
        for (int[] i : arrayToShow) {
            System.out.printf("Queen #%d on position [%d, %d]\n", count++, i[0], i[1]);
        }
    }
}

/*
    Output (first eight lines):
    Queen #1 on position [7, 2]
    Queen #2 on position [5, 3]
    Queen #3 on position [6, 5]
    Queen #4 on position [2, 4]
    Queen #5 on position [4, 1]
    Queen #6 on position [1, 6]
    Queen #7 on position [3, 7]
    Queen #8 on position [0, 0]
 */