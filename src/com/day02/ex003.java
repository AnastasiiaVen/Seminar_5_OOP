package com.day02;

/*

Написать программу вычисления n-ого треугольного числа

 */

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class ex003 {

    private static final Logger logger = Logger.getLogger(ex003.class.getName());

    public static void main(String[] args) {

        // Задаем параметры LogManager-а
        try {
            ClassLoader cl = ex003.class.getClassLoader();
            LogManager.getLogManager().readConfiguration(cl.getResourceAsStream("logging.properties"));
        }
        catch (IOException exception) {
            logger.log(Level.SEVERE, "Could not setup logger configuration. " +
                    "Exception: ", exception);
            System.err.println("Could not setup logger configuration: " + exception);
        }

        // Получаем натуральное число
        System.out.print("Set a natural number: ");
        Scanner iScanner = new Scanner(System.in);
        int number = iScanner.nextInt();
        // Вычисляем треугольное число
        int result = triangleNumber(number);
        String logString = String.format("Natural number: %d, result triangle number: %d", number, result);
        System.out.printf("Triangle number: %d%n", result);
        // Записываем в лог
        logger.info(logString);
    }

    public static int triangleNumber(int number) {
        return number == 0 ? 0 : number + triangleNumber(--number);
    }
}

/*

    Output:
    Set a natural number: 3
    Triangle number: 6

 */