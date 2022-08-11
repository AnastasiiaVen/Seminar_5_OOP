package com.day07;

public class DogImpl implements AnimalAction{

    // Реализация действия для Собаки
    @Override
    public void animalSays() {
        System.out.println("Dog says Gav!");
    }
}
