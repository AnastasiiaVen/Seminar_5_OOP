package com.day06;

public class Pers {

    private int age;
    private String first_name;
    private String last_name;


    Pers(String first_name, String last_name, int age) {
        this.age = age;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    @Override
    public String toString() {
        return String.format("%s %s", first_name, last_name);
    }
}
