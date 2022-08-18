package com.day11;

public class Pupil extends Human implements Studyble{

    private int schoolClass;

    public Pupil(String name, String surname, int age) {
        super(name, surname, age);
    }

    @Override
    public void study() {

    }
}
