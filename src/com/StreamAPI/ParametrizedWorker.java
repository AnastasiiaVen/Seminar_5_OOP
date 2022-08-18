package com.StreamAPI;

public class ParametrizedWorker<E> {
    private E id;
    String name;
    String surname;
    int age;
    int salary;

    public ParametrizedWorker(E id, String name, String surname, int age, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.salary = salary;
    }
}
