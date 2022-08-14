package com.day09;

import java.util.ArrayList;
import java.util.Iterator;

public class Family implements PersonRelation{

    private int i;
    private ArrayList<Human> family = new ArrayList<>();

    public ArrayList<Human> getFamily() {
        return family;
    }

    public void addFamilyMember(Human member) {
        this.family.add(member);
    }

    public Human getMemberByNameSurname(String name, String surname) {
        for (Human human : family) {
            if (name.equals(human.name) && surname.equals(human.surname)) {
                return human;
            }
        }
        return null;
    }

    @Override
    public void parentToChildRelation(Human parent, Human child) {
        Human parentInFamilyList = null;
        Human childInFamilyList = null;

        Iterator<Human> iterator = family.iterator();
        while (iterator.hasNext()) {
            Human temp = iterator.next();
            if (temp.equals(parent)) {
                parentInFamilyList = temp;
            } else if (temp.equals(child)) {
                childInFamilyList = temp;
            }
        }
        if (parentInFamilyList != null && childInFamilyList != null) {
            ((Person) parentInFamilyList).setChildren(childInFamilyList);
        }
    }

}
