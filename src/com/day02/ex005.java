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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ex005 {
    public static void main(String[] args) {
        // Читаем выражение из файла input.txt
        String inputString = getDataFromFile("src/com/day02/res/input.txt");
        System.out.println("Given the equation: " + inputString);
        // Вывод результата
        System.out.println(getSolution(inputString));
    }

    public static String getSolution(@NotNull String str) {
        // Формируем список. Разделитель - пробел, "+" и "=" исключаем
        ArrayList<String> list = new ArrayList<>(List.of(str.split(" ")));
        list.remove("+");
        list.remove("=");

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // Заменяем "?" в цикле от 0 до 9, сравниваем с результатом выражения
                int x = Integer.parseInt(list.get(0).replace("?", String.valueOf(i)));
                int y = Integer.parseInt(list.get(1).replace("?", String.valueOf(j)));
                if (x + y == Integer.parseInt(list.get(2))) {
                    // Решение найдено, формируем строку ответа
                    return String.format("Result: %d + %d = %d", x, y, Integer.parseInt(list.get(2)));
                }
            }
        }
        // Иначе решения нет
        return "No solution";
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