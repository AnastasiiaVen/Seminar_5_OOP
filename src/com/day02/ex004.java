package com.day02;

/*

Написать программу, показывающую последовательность действий для игры “Ханойская башня”

 */

import java.util.Scanner;

public class ex004 {

    static int iteration = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many discs? ");
        int n = input.nextInt();
        char a = 'A';
        char b = 'B';
        char c = 'C';

        hanoiTower(n, a, b, c);
    }

    public static void hanoiTower(int n, char a, char b, char c) {
        // Если остался один диск, перекладываем с А на С
        if (n == 1) {
            showMove(1, a, c);
        }
        else {
            // Рекурсивно располагаем слой n-1 со стойки A, через C, до B
            hanoiTower(n - 1, a, c, b);
            showMove(n, a, c);
            // Рекурсивно располагаем слой n-1 со стойки B, через A, до C
            hanoiTower(n - 1, b, a, c);
        }
    }

    public static void showMove(int n, char i, char j) {
        iteration++;
        System.out.println("Iteration " + iteration + " Disk " + n + " Move (from -> to) " + i + " -> " + j);
    }
}

/*
    Output:
    How many discs? 3
    Iteration 1 Disk 1 Move (from -> to) A -> C
    Iteration 2 Disk 2 Move (from -> to) A -> B
    Iteration 3 Disk 1 Move (from -> to) C -> B
    Iteration 4 Disk 3 Move (from -> to) A -> C
    Iteration 5 Disk 1 Move (from -> to) B -> A
    Iteration 6 Disk 2 Move (from -> to) B -> C
    Iteration 7 Disk 1 Move (from -> to) A -> C
 */