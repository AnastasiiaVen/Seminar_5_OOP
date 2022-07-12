package com.day05;

/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
 */

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ex020 {

    public static HashMap<Integer, Character> numberMap = new HashMap<>();

    public static void main(String[] args) {
        numberMap.put(1, 'I');
        numberMap.put(5, 'V');
        numberMap.put(1000, 'M');
        numberMap.put(500, 'D');
        numberMap.put(100, 'C');
        numberMap.put(50, 'L');
        numberMap.put(10, 'X');
        System.out.println(getRoman(250));

    }

    public static String getRoman(int initNum){
        StringBuilder sb = new StringBuilder();
        while (initNum > 0) {
            for (int i : numberMap.keySet()) {
                System.out.println(i);
                int temp = initNum / i;
                if (temp > 0 && temp < 4) {
                    //if (initNum / i == 9 || initNum / i == 4) sb.append()
                    for (int j = 0; j < temp; j++) {
                        sb.append(numberMap.get(i));
                        initNum -= i;
                    }

                }
            }
        }
        return sb.toString();
    }
}
