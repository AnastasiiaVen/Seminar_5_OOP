package com.day06;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class Relationships {
    // Список для хранения связей между персонами
    private final ArrayList<RelatedPersons> relationsList = new ArrayList<>();

    private static class Relation extends RelatedPersons {
        private final RelType relation;

        private Relation(Pers first_pers, Pers second_pers, RelType relation) {
            super(first_pers, second_pers);
            this.relation = relation;
        }

        // Читаемый вывод для связи между персонами.
        // Person Ivan Ivanov is PARENT for Pyotr Ivanov
        @Override
        public String toString() {
            return String.format("Person %s %s is %s for %s %s",
                    first_pers.getFirst_name(), first_pers.getLast_name(),
                    relation.toString(),
                    second_pers.getFirst_name(), second_pers.getLast_name());
        }
    }

    public void addRelation(Pers parent, Pers child) {
        // Добавляем две связи между персонами предок-потомок, потомок-предок
        relationsList.add(new Relation(parent, child, RelType.PARENT));
        relationsList.add(new Relation(child, parent, RelType.CHILD));
    }

    public ArrayList<Pers> findChildren(@NotNull Pers parent) {
        ArrayList<Pers> temp = new ArrayList<>();
        relationsList.forEach((rel) -> {
            if (parent.equals(rel.first_pers)) {
                temp.add(rel.second_pers);
            }
        });
        return temp;
    }

    public ArrayList<Pers> findParents(@NotNull Pers child) {
        ArrayList<Pers> temp = new ArrayList<>();
        relationsList.forEach((rel) -> {
            if (child.equals(rel.second_pers)) {
                temp.add(rel.first_pers);
            }
        });
        return temp;
    }

    public ArrayList<Pers> findBrothersSisters(Pers pers) {
        ArrayList<Pers> temp = new ArrayList<>();
        // Находим родителей
        ArrayList<Pers> parents = findParents(pers);
        relationsList.forEach((rel) -> {
            // Если имя/фамилия родителя совпадают
            if (parents.get(0).getFirst_name().equals(rel.first_pers.getFirst_name()) &&
                    parents.get(0).getLast_name().equals(rel.first_pers.getLast_name()) &&
                    // но это не он сам
                    !pers.getFirst_name().equals(rel.second_pers.getFirst_name()) &&
                    !pers.getLast_name().equals(rel.second_pers.getLast_name())) {
                temp.add(rel.second_pers);
            }
        });
        return temp;
    }

}
