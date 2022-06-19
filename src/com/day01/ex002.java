package com.day01;

/*

Даны два файла, в каждом из которых находится запись многочлена.
Сформировать файл содержащий сумму многочленов.

*/

import java.io.*;

public class ex002 {
    public static void main(String[] args) throws Exception {
        BufferedReader br01 = new BufferedReader(new FileReader("src/com/day01/res/polynomial_01.txt"));
        BufferedReader br02 = new BufferedReader(new FileReader("src/com/day01/res/polynomial_02.txt"));
        String pol01, pol02;
        pol01 = br01.readLine();
        pol02 = br02.readLine();
        br01.close();
        br02.close();
        System.out.println(pol01);
        System.out.println(pol02);
    }
}
