package com.day07;

public class CatImpl implements AnimalAction{

    // Реализация действия для Кота
    @Override
    public void animalSays() {
        System.out.println("Cat says Myau!");
    }
}
