package com.day01;

/*
Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых действий к минимуму.
Пример 1: а = 3, b = 2, ответ: 9
Пример 2: а = 2, b = -2, ответ: 0.25
Пример 3: а = 3, b = 0, ответ: 1
Пример 4: а = 0, b = 0, ответ: не определено
Пример 5
входные данные находятся в файле input.txt в виде
b 3
a 10
Результат нужно сохранить в файле output.txt
1000
*/

import org.jetbrains.annotations.NotNull;

import java.io.*;

public class ex01 {
    public static void main(String[] args) {
        int[] fileData = getDataFromFile("src/com/day01/res/input.txt");
        double result = getPow(fileData[0], fileData[1]);
        // Подготавливаем строку результата для записи в файл
        StringBuilder resultString = new StringBuilder();
        resultString.append(String.format("%d ^ %d = ", fileData[0], fileData[1]));
        // Если результат возведения в степень не равен "0", добавляем результат,
        // иначе результат не определен
        if (result != 0) resultString.append(result);
        else resultString.append("undefined");
        putResultToFile(String.valueOf(resultString), "src/com/day01/res/output.txt");
    }

    /*
    Output:
        output.txt contains
        2 ^ 8 = 256.0
        0 ^ 0 = undefined
        2 ^ -3 = 0.125
     */

    public static int @NotNull [] getDataFromFile(String path) {
        int[] fileData = new int[2];
        try (BufferedReader br = new BufferedReader(new FileReader(path));) {
            // Построчно читаем содержимое файла, разделяем по " ", записываем значения в массив
            for (int i = 0; i <= 1; i++) {
                String[] strArray = br.readLine().split(" ");
                fileData[i] = Integer.parseInt(strArray[1]);
            }
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return fileData;
    }

    public static void putResultToFile(String result, String path) {
        try (FileWriter writer = new FileWriter(path, true);) {
            // Файл открываем с возможностью добавления, записываем результат,
            // добавляем перенос строки
            writer.write(result);
            writer.append("\n");
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static double getPow(int a, int b) {
        // Для 0 0 возвращаем 0 (не определено)
        if (a == 0 && b == 0) return 0;
        // Для отрицательных значений показателя степени возвращаем 1/х
        return b < 0 ? 1 / powRecursion(a, Math.abs(b)) : powRecursion(a, Math.abs(b));
    }

    public static double powRecursion(int a, int b) {
        if (b < 1) return 1;
        else {
            if (b / 2 > 1) {
                double res = powRecursion(a, b / 2);
                return res * res;
            }
            else return powRecursion(a, b-1) * a;
        }
    }

}
