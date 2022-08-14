package com.day08;

/*
    Некоторые стандартные интерфейсы Java и примеры их использования
    Написать собственный класс с различными типами полей(String, int, etc) и отсортировать коллекцию,
    состоящию из экземпляр этого класса. В работе надо показать несколько реализаций:
    Через имплементацию интерфейса
    Через анонимный класс
    Через лямбда-выражение
    Отсортировать в обратном порядке
    Без явной передачи компоратора
    Реализовать свою структуру данных(например, односвязанный список) и уметь итерироваться по ней
 */

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Program{
    public static void main(String[] args) {

        ArrayList<Pet> pets = new ArrayList<>();

        pets.add(new Pet("Vaska", 5));
        pets.add(new Pet("Sonya", 4));
        pets.add(new Pet("Barsik", 7));

        pets.forEach((pet) -> System.out.println(pet));

        //Collections.sort(pets);
        pets.sort(new PetComparator());

        pets.forEach((pet) -> System.out.println(pet));


    }



}

