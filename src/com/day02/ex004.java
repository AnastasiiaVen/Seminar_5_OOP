package com.day02;

/*

Написать программу, показывающую последовательность действий для игры “Ханойская башня”

 */

import java.util.Scanner;


public class ex004 {

    static int iterations = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many discs? ");
        int n = input.nextInt();
        char a = 'A';
        char b = 'B';
        char c = 'C';

        tower(n, a, b, c);
    }

    public static void tower(int n, char a, char b, char c) {
        if (n == 1) {
            move(1, a, c);
        } else {
            // Рекурсивно располагаем слой n-1 со стойки A, через C, до B
            tower(n - 1, a, c, b);
            move(n, a, c);
            // Рекурсивно располагаем слой n-1 со стойки B, через A, до C
            tower(n - 1, b, a, c);
        }
    }

    public static void move(int n, char i, char j) {
        iterations++;
        System.out.println("Iteration " + iterations + " Disk " + n + " Move (from -> to) " + i + " -> " + j);
    }
}
