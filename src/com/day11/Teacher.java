package com.day11;

public class Teacher extends Human implements Teachable{
    @Override
    public void study() {
        System.out.printf("%s study\n", this.toString());
    }

    @Override
    public void teach(Pupil pupil) {
        String output = String.format("%s teach %s", this.toString(), pupil.toString());
        System.out.println(output);
    }

    public Teacher(String name, String surname, int age) {
        super(name, surname, age);
    }
}
