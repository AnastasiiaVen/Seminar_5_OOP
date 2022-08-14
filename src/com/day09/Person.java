package com.day09;

import java.util.ArrayList;

public class Person extends Human {

    private ArrayList<Human> children = new ArrayList<>();

    public Person(String name, String surname, int age) {
        super(name, surname, age);
    }

    public Person (String name, String surname){
        this(name, surname, 0);
    }

    public void setChildren(Human child){
        this.children.add(child);
    }

    public ArrayList<Human> getChildren() {
        return children;
    }

}
