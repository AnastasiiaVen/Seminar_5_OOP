package com.day04;

/*
    Написать программу вычисляющую значение сложного арифметического выражения.
    Для простоты - выражение всегда вычисляемое
    Пример: (2^3 * (10 / (5 - 3)))^(Sin(Pi)) ответ - 1
 */

import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;

public class PostfixNotation {
    public static void main(String[] args) {
        // Строка с инфиксной записью
        String initString = "(2^3*(10/(5-3)))^(Sin(Pi))";
        System.out.println("Infix notation:");
        System.out.println(initString);
        System.out.println("Postfix notation:");
        // Перевод в постфиксную запись
        String postfixString = getPostfix(initString);
        System.out.println(postfixString);
        System.out.println("Calculation result:");
        // Вычисляем запись
        if (!postfixString.equals("No result")) System.out.printf("%f", getResult(postfixString));
        else System.out.println("No result");
    }

    public static @NotNull String getPostfix(@NotNull String inputString) {
        // Разбиваем строку. Результат: [(, 2, ^, 3 , *, (, 10, /, (, 5, -, 3, ), ), ), ^, (, Sin, (, Pi, ), )]
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
                // "^", "Sin", "Cos" максимальный приоритет, заносим в стек
                // Открывающую скобку заносим в стек
                case "^", "Sin", "Cos", "(" -> operatorsStack.push(i);
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
                // Pi заносим в строку как double
                case "Pi" -> resultSb.append(Math.PI).append(" ");
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
        try {
            Double.parseDouble(checkString);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static @NotNull Double getResult(@NotNull String postfixString) {
        // Стек для операндов
        ArrayDeque<Double> operandsStack = new ArrayDeque<>();
        String[] postfixArray = postfixString.split(" ");
        for (String i : postfixArray) {
            // Если число, размещаем в стек операндов
            if (isNumeric(i)) operandsStack.push(Double.parseDouble(i));
            else {
                double x = 0;
                double y = 0;
                double tempResult = 0;
                // Для sin, cos из стека берем один операнд
                if (i.equals("Sin") || i.equals("Cos")) x = operandsStack.pop();
                // для всех других операторов берем из стека два верхних операнда
                else {
                    y = operandsStack.pop();
                    x = operandsStack.pop();
                }
                // Производим действие
                switch (i) {
                    case "+" -> tempResult = x + y;
                    case "-" -> tempResult = x - y;
                    case "*" -> tempResult = x * y;
                    case "/" -> tempResult = x / y;
                    case "^" -> tempResult = Math.pow(x, y);
                    case "Sin" -> tempResult = Math.sin(x);
                    case "Cos" -> tempResult = Math.cos(x);
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
    (2^3*(10/(5-3)))^(Sin(Pi))
    Postfix notation:
    2 3 ^ 10 5 3 - / * 3.141592653589793 Sin ^
    Calculation result:
    1,000000
 */
