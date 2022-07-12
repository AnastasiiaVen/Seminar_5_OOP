package com.day05;

/*
    Написать программу перевода int числа в римскую систему счисления.

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

import java.util.*;

public class Roman {

    public static HashMap<Integer, Character> romanCharMap = new HashMap<>();

    public static void main(String[] args) {
        // Заносим значения. Ключ - арабское представление, значение - римское
        romanCharMap.put(1, 'I');
        romanCharMap.put(5, 'V');
        romanCharMap.put(1000, 'M');
        romanCharMap.put(500, 'D');
        romanCharMap.put(100, 'C');
        romanCharMap.put(50, 'L');
        romanCharMap.put(10, 'X');

        // Test Map
        HashMap<Integer, String> testMap = new HashMap<>();
        testMap.put(3999, "MMMCMXCIX");
        testMap.put(44, "XLIV");
        testMap.put(100, "C");
        testMap.put(2022, "MMXXII");
        testMap.put(687, "DCLXXXVII");

        for (int i : testMap.keySet()) {
            System.out.printf("Arabic %d - Roman %s equals %s - %b\n", i, getRoman(i), testMap.get(i),
                    Objects.equals(testMap.get(i), getRoman(i)));
        }

    }

    public static String getRoman(int initNumber) {
        StringBuilder sb = new StringBuilder();
        // Подготавливаем сортированный список ключей numberMap.
        // Порядок сортировки от большего к меньшему
        List<Integer> sortedKeys = new ArrayList<>(romanCharMap.keySet());
        sortedKeys.sort(Collections.reverseOrder());
        while (initNumber > 0) {
            // Цикл идет по разрядам числа (1000, 100, 10, 1)
            for (int i = 0; i < sortedKeys.size(); i += 2) {
                int temp = initNumber / sortedKeys.get(i);
                switch (temp) {
                    // 9 в римской записи представляется как 10 - 1 или IX
                    // соответственно в текущем разряде i + (i-2)
                    case 9 -> {
                        sb.append(romanCharMap.get(sortedKeys.get(i)));
                        sb.append(romanCharMap.get(sortedKeys.get(i - 2)));
                        initNumber -= temp * sortedKeys.get(i);
                    }
                    // Для значений 4 < i < 9 добавляем промежуточную запись кратную 5, 50, 500
                    case 5, 6, 7, 8 -> {
                        sb.append(romanCharMap.get(sortedKeys.get(i - 1)));
                        initNumber -= sortedKeys.get(i - 1);
                    }
                    // Для 4 записываем 500-100 - CD, 50-10 - XL, 5-1 - IV
                    case 4 -> {
                        sb.append(romanCharMap.get(sortedKeys.get(i)));
                        sb.append(romanCharMap.get(sortedKeys.get(i - 1)));
                        initNumber -= temp * sortedKeys.get(i);
                    }
                    // Записываем необходимое количество знаков
                    case 1, 2, 3 -> {
                        for (int j = 0; j < temp; j++) {
                            sb.append(romanCharMap.get(sortedKeys.get(i)));
                            initNumber -= sortedKeys.get(i);
                        }
                    }
                }
            }
        }
        return sb.toString();
    }
}
/*
    Output:
    Arabic 100 - Roman C equals C - true
    Arabic 2022 - Roman MMXXII equals MMXXII - true
    Arabic 44 - Roman XLIV equals XLIV - true
    Arabic 3999 - Roman MMMCMXCIX equals MMMCMXCIX - true
    Arabic 687 - Roman DCLXXXVII equals DCLXXXVII - true
 */
