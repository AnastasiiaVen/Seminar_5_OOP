package com.day04;

/*
    Реализовать алгоритм перевода из инфиксной записи в постфиксную для арифметического выражения.
    Вычислить запись если это возможно
 */

import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;

public class ex010 {
    public static void main(String[] args) {
        String initString = "1+2*(14-12)^3";
        System.out.println("Infix notation:");
        System.out.println(initString);
        System.out.println("Postfix notation:");
        System.out.println(getPostfix(initString));
    }

    public static @NotNull String getPostfix(String inputString) {
        String[] stringArray = inputString.split("(?<=[-+*/^()])|(?=[-+*/^()])");
        StringBuilder resultSb = new StringBuilder();
        ArrayDeque<String> operatorStack = new ArrayDeque<>();
        for (String i : stringArray) {
            switch (i) {
                case "+", "-" -> {
                    // Смотрим стек, если сверху есть приоритетный или равный по приоритету оператор,
                    // выносим его в строку и заносим оператор в стек
                    // (операторы имеют низший приоритет, если в стеке не скобка, выносим в строку)
                    if (operatorStack.peek() != null) {
                        if (!operatorStack.peekFirst().equals("(")) {
                            resultSb.append(operatorStack.pop()).append(" ");
                        }
                    }
                    operatorStack.push(i);
                }
                case "*", "/" -> {
                    // Смотрим стек, если сверху есть приоритетный или равный по приоритету оператор,
                    // выносим его в строку и заносим оператор в стек
                    if (operatorStack.peek() != null) {
                        String temp = operatorStack.peekFirst();
                        if (temp.equals("^") || temp.equals("*") || temp.equals("/")) {
                            resultSb.append(operatorStack.pop()).append(" ");
                        }
                    }
                    operatorStack.push(i);
                }
                // "^" максимальный приоритет, заносим в стек
                // Открывающую скобку заносим в стек
                case "^", "(" -> operatorStack.push(i);
                case ")" -> {
                    // Переносим все операторы до появления открывающей скобки. Скобку удаляем из стека
                    while (true) {
                        assert operatorStack.peekFirst() != null;
                        if (operatorStack.peekFirst().equals("(")) break;
                        resultSb.append(operatorStack.pop()).append(" ");
                    }
                    operatorStack.pop();
                }
                default -> {
                    if (isNumeric(i)) resultSb.append(i).append(" ");
                }
            }
        }
        // Выталкиваем оставшиеся операторы из стека, добавляем в строку
        while (operatorStack.peek() != null) resultSb.append(operatorStack.pop()).append(" ");
        return resultSb.toString();
    }

    public static boolean isNumeric(String checkString) {
        for (char c : checkString.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
