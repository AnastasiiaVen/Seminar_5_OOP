package com.day02;

/*

Задано уравнение вида q + w = e, q, w, e >= 0.
Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69.
Требуется восстановить выражение до верного равенства.
Предложить хотя бы одно решение или сообщить, что его нет

 */

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;

public class ex005 {
    public static void main(String[] args) {
        // Читаем выражение из файла input.txt
        String inputString = getDataFromFile("src/com/day02/res/input.txt");
        System.out.println("Given the equation: " + inputString);
        // Вывод результата
        System.out.printf("Result: %s", getSolution(inputString));
    }

    public static String getSolution(@NotNull String str) {
        // Заменяем "?" в выражении нулями, формируем массив (разделитель - пробел)
        String [] strArray = str.replace("?", "0").split(" ");
        int[] numArray = new int[3];
        int j = 0;
        // Извлекаем из массива типа String числовые значения
        for (String i : strArray) {
            if (isNumeric(i)) {
                numArray[j] = Integer.parseInt(i);
                j++;
            }
        }
        // Находим искомую разницу
        int findInt = numArray[2] - (numArray[0] + numArray[1]);
        // Если результат отрицательный, решения нет
        if (findInt < 0) return "No solution";
        else {
            // Иначе формируем строку с ответом
            StringBuilder sb = new StringBuilder();
            if (numArray[0] / 10 > 0) {
                sb.append(numArray[0] + findInt % 10).append(" + ");
                sb.append(numArray[1] + (findInt / 10)*10).append(" = ").append(numArray[2]);
            }
            else {
                sb.append(numArray[1] + findInt % 10).append(" + ");
                sb.append(numArray[0] + (findInt / 10)*10).append(" = ").append(numArray[2]);
            }
            return String.valueOf(sb);
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public static String getDataFromFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
            return "";
        }
    }
}

/*

    Output:
    Given the equation: 2? + ?5 = 69
    Result: 24 + 45 = 69

 */