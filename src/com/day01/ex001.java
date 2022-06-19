package com.day01;

/*
Задана натуральная степень k. Сформировать случайным образом список коэффициентов
(значения от 0 до 100) многочлена многочлен степени k.
Пример: k=2 => 2*x² + 4*x + 5 = 0 или x² + 5 = 0 или 10*x² = 0
*/

import com.libraries.*;
import java.util.Random;

public class ex001 {
    public static void main(String[] args) {
        System.out.println("Set pow k");
        int k = readFromConsole.getInt();

        Random rnd = new Random();
        StringBuilder resultString = new StringBuilder();

        for (int i = k; i > 0; i--) {
            int kf = rnd.nextInt(100);
            resultString.append(kf).append("x^").append(i).append(" + ");
        }
        resultString.append(rnd.nextInt(100)).append(" = 0");

        System.out.println(resultString);
    }
}

//  Output:
//  Set pow k
//  7
//  14x^7 + 25x^6 + 57x^5 + 89x^4 + 24x^3 + 54x^2 + 44x^1 + 11 = 0