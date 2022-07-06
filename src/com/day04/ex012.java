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
            System.out.printf("Bracket placement is correct? %s - %s\n",
                    i, bracketsIsCorrect(i));
        }
    }

    public static boolean bracketsIsCorrect(@NotNull String expression) {
        char[] expressionArray = expression.toCharArray();
        ArrayDeque<Character> brackets = new ArrayDeque<>();
        HashMap<Character, Character> bracketsMap = new HashMap<>();
        bracketsMap.put(')', '(');
        bracketsMap.put('>', '<');
        bracketsMap.put(']', '[');
        bracketsMap.put('}', '{');
        for (char i : expressionArray) {
            switch (i) {
                case '(', '<', '[', '{' -> brackets.push(i);
                case ')', '>', ']', '}' -> {
                    if (brackets.peek() == null || bracketsMap.get(i) != brackets.pop()) return false;
                }
            }
        }
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
