package com.day09;

import java.util.Objects;

public abstract class Human {
    protected String name;
    protected String surname;
    protected int age;

    public Human(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, surname: %s, age: %d", name, surname, age);
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(this.name, ((Person) obj).name) &&
                Objects.equals(this.surname, ((Person) obj).surname);
    }

}
