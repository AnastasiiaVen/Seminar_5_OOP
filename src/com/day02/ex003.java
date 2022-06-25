package com.day02;

/*

Написать программу вычисления n-ого треугольного числа

 */

import java.util.Scanner;

public class ex003 {
    public static void main(String[] args) {
        System.out.print("Set a natural number: ");
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Triangle number: %d%n", triangleNumber(iScanner.nextInt()));
    }

    public static int triangleNumber(int number) {
        return number == 0 ? 0 : number + triangleNumber(--number);
    }
}

/*

    Output:
    Set a natural number: 3
    Triangle number: 6

 */