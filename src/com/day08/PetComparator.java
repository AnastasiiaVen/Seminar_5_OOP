package com.day08;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class PetComparator implements Comparator<Pet>{


    @Override
    public int compare(Pet o1, Pet o2) {
        if (o1.getAge() > o2.getAge()) return 1;
        else if (o1.getAge() < o2.getAge()) return -1;
        else return 0;

    }
}
