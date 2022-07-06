package com.day04;

/*
    Реализовать алгоритм перевода из инфиксной записи в постфиксную для арифметического выражения.
    Вычислить запись если это возможно
 */

import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;

public class ex010 {
    public static void main(String[] args) {
        // Строка с инфиксной записью
        String initString = "3/3+2*(14-12)^3";
        System.out.println("Infix notation:");
        System.out.println(initString);
        System.out.println("Postfix notation:");
        // Перевод в постфиксную запись
        String postfixString = getPostfix(initString);
        System.out.println(postfixString);
        System.out.println("Calculation result:");
        // Вычисляем запись
        if (!postfixString.equals("No result")) System.out.println(getResult(postfixString));
        else System.out.println("No result");
    }

    public static @NotNull String getPostfix(@NotNull String inputString) {
        // Разбиваем строку. Результат: [3, /, 3, +, 2, *, (, 14, -, 12, ), ^, 3]
        String[] stringArray = inputString.split("(?<=[-+*/^()])|(?=[-+*/^()])");
        // StringBuilder для формирования постфиксной записи
        StringBuilder resultSb = new StringBuilder();
        // Стек для операторов
        ArrayDeque<String> operatorsStack = new ArrayDeque<>();
        for (String i : stringArray) {
            switch (i) {
                case "+", "-" -> {
                    // Смотрим стек, если сверху есть приоритетный или равный по приоритету оператор,
                    // выносим его в строку и заносим оператор в стек
                    // (операторы имеют низший приоритет, если в стеке не скобка, выносим в строку)
                    if (operatorsStack.peek() != null) {
                        if (!operatorsStack.peekFirst().equals("(")) {
                            resultSb.append(operatorsStack.pop()).append(" ");
                        }
                    }
                    operatorsStack.push(i);
                }
                case "*", "/" -> {
                    // Смотрим стек, если сверху есть приоритетный или равный по приоритету оператор,
                    // выносим его в строку и заносим оператор в стек
                    if (operatorsStack.peek() != null) {
                        String temp = operatorsStack.peekFirst();
                        if (temp.equals("^") || temp.equals("*") || temp.equals("/")) {
                            resultSb.append(operatorsStack.pop()).append(" ");
                        }
                    }
                    operatorsStack.push(i);
                }
                // "^" максимальный приоритет, заносим в стек
                // Открывающую скобку заносим в стек
                case "^", "(" -> operatorsStack.push(i);
                case ")" -> {
                    // Переносим все операторы из стека в строку до появления открывающей скобки.
                    // Открывающую скобку удаляем из стека
                    while (true) {
                        assert operatorsStack.peekFirst() != null;
                        if (operatorsStack.peekFirst().equals("(")) break;
                        resultSb.append(operatorsStack.pop()).append(" ");
                    }
                    operatorsStack.pop();
                }
                default -> {
                    // По умолчанию ожидаем число. Если проверка возвращает истину,
                    // записываем число в строку
                    if (isNumeric(i)) resultSb.append(i).append(" ");
                    // При некорректно заданном выражении
                    else return "No result";
                }
            }
        }
        // Выталкиваем оставшиеся операторы из стека, добавляем в строку
        while (operatorsStack.peek() != null) resultSb.append(operatorsStack.pop()).append(" ");
        return resultSb.toString().trim();
    }

    public static boolean isNumeric(@NotNull String checkString) {
        for (char c : checkString.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public static @NotNull Integer getResult(@NotNull String postfixString) {
        // Стек для операндов
        ArrayDeque<Integer> operandsStack = new ArrayDeque<>();
        String[] postfixArray = postfixString.split(" ");
        for (String i : postfixArray) {
            // Если число, размещаем в стек операндов
            if (isNumeric(i)) operandsStack.push(Integer.parseInt(i));
            else {
                // Берем из стека два верхних операнда
                int y = operandsStack.pop();
                int x = operandsStack.pop();
                int tempResult = 0;
                // Производим действие
                switch (i) {
                    case "+" -> tempResult = x + y;
                    case "-" -> tempResult = x - y;
                    case "*" -> tempResult = x * y;
                    case "/" -> tempResult = x / y;
                    case "^" -> tempResult = (int) Math.pow(x, y);
                }
                // Результат помещаем в стек
                operandsStack.push(tempResult);
            }
        }
        // Оставшееся в стеке значение является результатом вычисления
        return operandsStack.pop();
    }
}

/*
    Output:
    Infix notation:
    3/3+2*(14-12)^3
    Postfix notation:
    3 3 / 2 14 12 - 3 ^ * +
    Calculation result:
    17
 */
