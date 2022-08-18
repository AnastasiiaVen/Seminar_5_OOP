package com.day10;

/*
Обобщения. ч1
Реализовать собственный ArrayList
Более сложная задача: Реализовать собственный список или двунаправленный список
Методы, которые должны присутстовать:
        add - добавляет элемент
        get by index - получить элемент
        remove by index and by element - удаляет элемент
        set - ставит элемент в нужную позицию
        indexOf - получить индекс элемента
        contains - проверка наличия элемента
addAll - добавляет в текущий список другой список
removeAll - удаляет из списка все элементы другого списка
sort - сортировка
clear - очищает список
 */

public class Program {
    public static void main(String[] args) {

        MyArrayList<Integer> intList = new MyArrayList<>();
        intList.add(111);
        intList.add(222);
        intList.add(333);
        intList.add(444);
        intList.add(555);
        intList.add(666);
        intList.add(777);
        intList.add(888);
        System.out.println(intList);
        System.out.println(intList.size());

        MyArrayList<String> strList = new MyArrayList<>();
        strList.add("This is string");
        System.out.println(strList);

        System.out.println(strList.getByIndex(0).toString());
        System.out.println(intList.getByIndex(1).toString());

        System.out.println(intList.contains(123));
        System.out.println(intList.contains(1));

        System.out.println(intList.indexOf(333));

        intList.removeByIndex(2);
        System.out.println(intList);

        intList.removeByElement(777);
        System.out.println(intList);

    }
}
