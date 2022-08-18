package com.day11;

public class Director extends Teacher implements Manageble{

    public Director(String name, String surname, int age) {
        super(name, surname, age);
    }

    @Override
    public void getPayments() {

    }

    @Override
    public void outTeacher() {

    }
}
