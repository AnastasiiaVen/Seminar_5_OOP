package com.day04;

/*
    Написать программу, определяющую правильность расстановки скобок в выражении.
    Пример 1: a+(d*3) - истина
    Пример 2: [a+(1*3) - ложь
    Пример 3: [6+(3*3)] - истина
    Пример 4: {a}[+]{(d*3)} - истина
    Пример 5: <{a}+{(d*3)}> - истина
    Пример 6: {a+]}{(d*3)} - ложь
 */

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class ex012 {
    public static void main(String[] args) {
        String[] initStrings = {
                "a+(d*3)",
                "[a+(1*3)",
                "[6+(3*3)]",
                "{a}[+]{(d*3)}",
                "<{a}+{(d*3)}>",
                "{a+]}{(d*3)}"
        };
        for (String i : initStrings) {
            System.out.printf("Bracket placement is correct? %s - %s\n", i, bracketsIsCorrect(i));
        }
    }

    public static boolean bracketsIsCorrect(@NotNull String expression) {
        // Разбиваем строку на char-ы
        char[] expressionArray = expression.toCharArray();
        ArrayDeque<Character> brackets = new ArrayDeque<>();
        // Словарь для скобок
        HashMap<Character, Character> bracketsMap = new HashMap<>();
        bracketsMap.put(')', '(');
        bracketsMap.put('>', '<');
        bracketsMap.put(']', '[');
        bracketsMap.put('}', '{');
        for (char i : expressionArray) {
            switch (i) {
                // Открывающие скобки заносим в стек
                case '(', '<', '[', '{' -> brackets.push(i);
                // Закрывающие скобки проверяем на соответствие пары ключ - значение словаря
                // При несоответствии или пустом стеке - выражение не правильно
                case ')', '>', ']', '}' -> {
                    if (brackets.peek() == null || bracketsMap.get(i) != brackets.pop()) return false;
                }
            }
        }
        // Если в конце стек не пуст, также выражение не правильно. Иначе true
        return brackets.peek() == null;
    }
}

/*
    Output:
    Bracket placement is correct? a+(d*3) - true
    Bracket placement is correct? [a+(1*3) - false
    Bracket placement is correct? [6+(3*3)] - true
    Bracket placement is correct? {a}[+]{(d*3)} - true
    Bracket placement is correct? <{a}+{(d*3)}> - true
    Bracket placement is correct? {a+]}{(d*3)} - false
 */
