package com.day03;

/*
    Шахматную доску размером NxN обойти конём так, чтобы фигура в каждой
    клетке была строго один раз.
 */

public class ex008 {
    public static void main(String[] args) {
        int[][] board = new int[10][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                setHorse(board, i, j, 1);
            }
        }
    }

    public static void setHorse(int[][] board, int coordX, int coordY, int count) {
        if (count > board.length * board[0].length) {
            showArray(board);
            System.out.println(" ");
            return;
        }
        if (coordX < 0 || coordY < 0 || coordX >= board.length || coordY >= board[0].length ||
                board[coordX][coordY] != 0) return;
        board[coordX][coordY] = count;
        setHorse(board, coordX + 2, coordY + 1, count + 1);
        setHorse(board, coordX + 2, coordY - 1, count + 1);
        setHorse(board, coordX - 2, coordY + 1, count + 1);
        setHorse(board, coordX - 2, coordY - 1, count + 1);
        setHorse(board, coordX + 1, coordY + 2, count + 1);
        setHorse(board, coordX - 1, coordY + 2, count + 1);
        setHorse(board, coordX + 1, coordY - 2, count + 1);
        setHorse(board, coordX - 1, coordY - 2, count + 1);
        board[coordX][coordY] = 0;
    }

    public static void showArray(int[][] board) {
        for (int[] i : board) {
            for (int j : i) {
                System.out.printf("%3d", j);
            }
            System.out.println(" ");
        }
    }
}
