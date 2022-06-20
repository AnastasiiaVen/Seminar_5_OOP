package com.day02;

/*

На вход некоторому исполнителю подаётся два числа (a, b). У исполнителя есть две команды
- команда 1 (к1): увеличить в с раза, а умножается на c
- команда 2 (к2): увеличить на d ( +2 ), к a прибавляется d
написать программу, которая выдаёт набор команд, позволяющий число a превратить в число b
или сообщить, что это невозможно
Пример 1: а = 1, b = 7, c = 2, d = 1
ответ: к1, к1, к1, к1, к1, к1 или к1, к2, к1, к1, к1 или к1, к1, к2, к1.
Пример 2: а = 11, b = 7, c = 2, d = 1
ответ: нет решения.
*Подумать над тем, как сделать минимальное количество команд

 */

public class ex002 {
    public static void main(String[] args) {
        int a = 1;
        int b = 7;
        int c = 2;  // k1
        int d = 1;  // k2

        recursiveSolve(a, b, c, d, "");
    }

    public static void recursiveSolve(int a, int b, int c, int d, String result) {
        if (a > b) return;
        if (b == a) {
            System.out.println(result);
            return;
        }
        recursiveSolve(a * c, b, c, d, result + "k1 ");
        recursiveSolve(a + d, b, c, d, result + "k2 ");
    }
}
