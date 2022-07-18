package com.day05;

/*
    Реализовать волновой алгоритм
 */

import java.util.*;

public class Waves {
    // Дискретное рабочее поле
    static int[][] field = new int[15][20];
    // HashMap где ключ - номнр шага от стартовой ячейки,
    // значение - список координат с одинаковым номером шага
    static Map<Integer, ArrayList<coordinates>> coordinatesMap = new HashMap<>();
    // Массив с приращениями координат (движение вниз, вверх ...)
    static int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static coordinates startPoint = new coordinates();
    static coordinates finishPoint = new coordinates();

    static {
        Random random = new Random();
        // Рандомно расставляем препятствия. На поле отмечаем их "-1"
        for (int i = 0; i < 40; i++) {
            field[random.nextInt(15)][random.nextInt(20)] = -1;
        }
        // Рандомно точка старта
        startPoint.x = random.nextInt(5);
        startPoint.y = random.nextInt(5);
        // Стартовой ячейке присваиваем "1"
        field[startPoint.x][startPoint.y] = 1;
        // Рандомно точка финиша
        finishPoint.x = random.nextInt(5) + 10;
        finishPoint.y = random.nextInt(5) + 15;
        field[finishPoint.x][finishPoint.y] = 0;
        // Стартовую точку с координатами заносим в Map
        ArrayList<coordinates> temp = new ArrayList<>();
        temp.add(new coordinates(startPoint.x, startPoint.y));
        coordinatesMap.put(1, temp);
    }

    public static void main(String[] args) {
        // Распространение волны
        makeWaves(1);
        // Если финишная точка отлична от 0, решение есть
        if (field[finishPoint.x][finishPoint.y] != 0) {
            // Восстановление пути
            ArrayList<coordinates> path = backTrace(new ArrayList<>(), finishPoint.x, finishPoint.y,
                    field[finishPoint.x][finishPoint.y]);
            // Подготовка поля для вывода
            path.forEach(coordinate -> field[coordinate.x][coordinate.y] = -2);
            field[startPoint.x][startPoint.y] = -3;
            field[finishPoint.x][finishPoint.y] = -4;
            // Вывод результата
            showField();
        } else System.out.println("No solution");
    }

    public static void makeWaves(int count) {
        // Временный список с координатами
        ArrayList<coordinates> temp = new ArrayList<>();
        // для всего списка координат по текущему ключу
        for (coordinates i : coordinatesMap.get(count)) {
            for (int[] j : moves) {
                // Проверяем возможные движения
                if (i.x + j[0] >= 0 && i.x + j[0] < field.length
                        && i.y + j[1] >= 0 && i.y + j[1] < field[0].length
                        && field[i.x + j[0]][i.y + j[1]] == 0) {
                    // При выполнении условий координаты заносим в список,
                    // на поле отмечаем как n+1
                    temp.add(new coordinates(i.x + j[0], i.y + j[1]));
                    field[i.x + j[0]][i.y + j[1]] = count + 1;
                }
            }
        }
        // Условие выхода из рекурсии. Если не сделано ни одного движения
        // список с координатами пуст
        if (temp.size() == 0) return;
        // Иначе список координат вносим в Map с ключем n+1, рекурсивно повторяем
        coordinatesMap.put(count + 1, temp);
        makeWaves(count + 1);
    }

    public static ArrayList<coordinates> backTrace(ArrayList<coordinates> path,
                                                   int coordX, int coordY, int count) {
        if (count == 1) return path;
        // Для возможных вариантов перемещения проверяем условия:
        // координаты в пределах массива, значение следующей позиции на 1 меньше текущей
        for (int[] i : moves) {
            if (coordX + i[0] >= 0 && coordY + i[1] >= 0
                    && coordX + i[0] < field.length && coordY + i[1] < field[0].length
                    && field[coordX + i[0]][coordY + i[1]] == count - 1) {
                // Вносим координаты в список, рекурсивно повторяем до 1 (стартовая точка)
                path.add(new coordinates(coordX + i[0], coordY + i[1]));
                return backTrace(path, coordX + i[0], coordY + i[1], count - 1);
            }
        }
        return path;
    }

    static class coordinates {
        int x;
        int y;

        public coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public coordinates() {
            this.x = 0;
            this.y = 0;
        }
    }

    public static void showField() {
        for (int[] i : field) {
            for (int j : i) {
                switch (j) {
                    case -1 -> System.out.print("ZZ ");
                    case -2 -> System.out.print(" * ");
                    case -3 -> System.out.print("St ");
                    case -4 -> System.out.print("Fn ");
                    default -> System.out.print(" . ");
                }
            }
            System.out.println(" ");
        }
    }
}

/*
    Output:
    .  .  .  .  .  .  .  .  .  .  .  . ZZ  .  . ZZ  .  .  .  .
    .  .  .  .  .  . ZZ  .  .  .  .  .  .  .  .  .  .  .  .  .
    .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  . ZZ  .
    . St  .  . ZZ  . ZZ  .  .  .  .  .  .  .  .  . ZZ  . ZZ  .
    .  *  .  .  . ZZ  . ZZ ZZ  .  .  .  .  .  .  . ZZ  .  .  .
    .  *  .  .  .  .  .  . ZZ  .  .  .  .  .  .  . ZZ  . ZZ  .
    .  *  .  .  .  .  .  .  .  .  .  . ZZ  . ZZ  .  .  .  .  .
    .  *  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .
    .  *  *  *  .  .  .  .  .  .  .  .  .  .  .  .  . ZZ  .  .
    .  . ZZ  *  . ZZ ZZ  .  .  .  .  .  .  .  .  . ZZ  .  .  .
    . ZZ  .  *  .  .  .  . ZZ  .  .  .  .  .  .  .  .  .  .  .
    . ZZ  .  *  * ZZ ZZ  .  .  .  .  .  .  . ZZ  . ZZ  . ZZ  .
    .  .  . ZZ  *  *  *  .  . ZZ  .  .  .  .  . ZZ  .  .  .  .
    .  .  .  .  . ZZ  *  *  *  *  *  *  *  *  *  *  *  * Fn  .
    .  .  .  .  .  .  .  .  .  . ZZ  .  .  .  .  .  .  .  .  .
 */
