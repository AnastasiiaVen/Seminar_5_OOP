package com.libraries;
import java.util.Scanner;

public class readFromConsole {
    public static int getInt() {
        Scanner iScanner = new Scanner(System.in);
        while (!iScanner.hasNextInt()) {
            System.out.println("Неверный ввод");
        }
        return iScanner.nextInt();
    }

}
