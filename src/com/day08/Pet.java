package com.day08;

import org.jetbrains.annotations.NotNull;

public class Pet implements Comparable<Pet> {
    private String name;
    private int age;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(@NotNull Pet o) {
        if (this.age > o.age) return 1;
        else if (this.age < o.age) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age %d", name, age);
    }
}
