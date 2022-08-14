package com.day09;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class HumanComparator implements Comparator<Human> {
    @Override
    public int compare(@NotNull Human human1, @NotNull Human human2) {
        return Integer.compare(human1.age, human2.age);
    }
}
