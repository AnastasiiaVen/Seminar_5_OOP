package com.day09;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class Research {

    public ArrayList<Human> findParents(@NotNull Family family, String name, String surname) {
        ArrayList<Human> parents = new ArrayList<>();
        Human child = family.getMemberByNameSurname(name, surname);
        for (Human human : family.getFamily()) {
            for (Human temp : ((Person) human).getChildren()) {
                if (child.equals(temp)) {
                    parents.add(human);
                }
            }
        }
        return parents;
    }

    public ArrayList<Human> findChildren(@NotNull Family family, String name, String surname) {
        return ((Person) family.getMemberByNameSurname(name, surname)).getChildren();
    }

    public ArrayList<Human> findBrothersSisters(@NotNull Family family, String name, String surname) {
        Set<Human> brothersNSisters = null;
        ArrayList<Human> parents = findParents(family, name, surname);
        Human member = family.getMemberByNameSurname(name, surname);

        for (Human parent : parents) {
            brothersNSisters = ((Person) parent).getChildren().stream()
                    .filter(h -> !h.equals(member)).collect(Collectors.toSet());
        }
        assert brothersNSisters != null;
        return new ArrayList<>(brothersNSisters);
    }

}
