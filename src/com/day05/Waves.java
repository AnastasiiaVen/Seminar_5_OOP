package com.day05;

/*
    Реализовать волновой алгоритм/
 */

import java.util.*;

public class Waves {
    // Дискретное рабочее поле
    static int[][] field = new int[15][20];
    // HashMap где ключ - номнр шага от стартовой ячейки,
    // значение - список координат с одинаковым номером шага
    static Map<Integer, ArrayList<coordinates>> coordinatesMap = new HashMap<>();
    // Список с приращениями координат
    static ArrayList<coordinates> moves = new ArrayList<>();
    static coordinates startPoint = new coordinates();
    static coordinates finishPoint = new coordinates();

    static {
        // Заполняем список (движение вниз, вверх ...)
        moves.add(new coordinates(0, 1));
        moves.add(new coordinates(0, -1));
        moves.add(new coordinates(1, 0));
        moves.add(new coordinates(-1, 0));

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
            for (coordinates m : moves) {
                // Проверяем возможные движения
                if (i.x + m.x >= 0 && i.x + m.x < field.length
                        && i.y + m.y >= 0 && i.y + m.y < field[0].length
                        && field[i.x + m.x][i.y + m.y] == 0) {
                    // При выполнении условий координаты заносим в список,
                    // на поле отмечаем как n+1
                    temp.add(new coordinates(i.x + m.x, i.y + m.y));
                    field[i.x + m.x][i.y + m.y] = count + 1;
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
        for (coordinates m : moves) {
            if (coordX + m.x >= 0 && coordY + m.y >= 0
                    && coordX + m.x < field.length && coordY + m.y < field[0].length
                    && field[coordX + m.x][coordY + m.y] == count - 1) {
                // Вносим координаты в список, рекурсивно повторяем до 1 (стартовая точка)
                path.add(new coordinates(coordX + m.x, coordY + m.y));
                return backTrace(path, coordX + m.x, coordY + m.y, count - 1);
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
