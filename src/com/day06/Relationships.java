package com.day06;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class Relationships {
    // Список для хранения связей между персонами
    private final ArrayList<RelatedPersons> relationsList = new ArrayList<>();

    private static class Relation extends RelatedPersons {
        private final RelType relation;

        private Relation(Person first_person, Person second_person, RelType relation) {
            super(first_person, second_person);
            this.relation = relation;
        }

        // Читаемый вывод для связи между персонами.
        // Person Ivan Ivanov is PARENT for Pyotr Ivanov
        @Override
        public String toString() {
            return String.format("Person %s %s is %s for %s %s",
                    first_person.getFirst_name(), first_person.getLast_name(),
                    relation.toString(),
                    second_person.getFirst_name(), second_person.getLast_name());
        }
    }

    public void addRelation(Person parent, Person child) {
        // Добавляем две связи между персонами предок-потомок, потомок-предок
        relationsList.add(new Relation(parent, child, RelType.PARENT));
        relationsList.add(new Relation(child, parent, RelType.CHILD));
    }

    // Найти всех детей персоны
    public ArrayList<Person> findChildren(@NotNull Person parent) {
        ArrayList<Person> temp = new ArrayList<>();
        relationsList.forEach((rel) -> {
            if (parent.equals(rel.first_person)) {
                temp.add(rel.second_person);
            }
        });
        return temp;
    }

    // Найти родителей персоны
    public ArrayList<Person> findParents(@NotNull Person child) {
        ArrayList<Person> temp = new ArrayList<>();
        relationsList.forEach((rel) -> {
            if (child.equals(rel.second_person)) {
                temp.add(rel.first_person);
            }
        });
        return temp;
    }

    // Найти сестер/братьев
    public ArrayList<Person> findBrothersSisters(Person person) {
        ArrayList<Person> temp = new ArrayList<>();
        // Находим родителей
        ArrayList<Person> parents = findParents(person);
        relationsList.forEach((rel) -> {
            // Если имя/фамилия родителя совпадают
            if (parents.get(0).getFirst_name().equals(rel.first_person.getFirst_name()) &&
                    parents.get(0).getLast_name().equals(rel.first_person.getLast_name()) &&
                    // но это не он сам
                    !person.getFirst_name().equals(rel.second_person.getFirst_name()) &&
                    !person.getLast_name().equals(rel.second_person.getLast_name())) {
                temp.add(rel.second_person);
            }
        });
        return temp;
    }

}
