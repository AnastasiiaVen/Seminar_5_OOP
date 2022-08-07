package com.day06;


public class Family_tree {
    public static void main(String[] args) {
        Person grandPa = new Person("Ivan", "Ivanov", 65);
        Person grandMom = new Person("Xenia", "Onatopp", 65);
        Person parent_01 = new Person("Pyotr", "Ivanov", 35);
        Person parent_02 = new Person("Ann", "Petrova", 36);
        Person parent_03 = new Person("Olga", "Ivanova", 37);
        Person parent_04 = new Person("Vasily", "Sidorov", 38);
        Person child_01 = new Person("Sergey", "Ivanov", 12);
        Person child_02 = new Person("Mary", "Ivanova", 13);
        Person child_03 = new Person("Semyon", "Sidorov", 14);

        Relationships familyRelations = new Relationships();
        // При вызове addRelation указываем только связь предок-потомок
        // addRelation добавляет связи PARENT и CHILD между двумя персонами
        familyRelations.addRelation(grandPa, parent_01);
        familyRelations.addRelation(grandPa, parent_03);
        familyRelations.addRelation(grandMom, parent_01);
        familyRelations.addRelation(grandMom, parent_03);
        familyRelations.addRelation(parent_01, child_01);
        familyRelations.addRelation(parent_01, child_02);
        familyRelations.addRelation(parent_02, child_01);
        familyRelations.addRelation(parent_02, child_02);
        familyRelations.addRelation(parent_03, child_03);
        familyRelations.addRelation(parent_04, child_03);

        // Находим детей Ивана Иванова
        System.out.printf("%s %s's children:\n", grandPa.getFirst_name(), grandPa.getLast_name());
        familyRelations.findChildren(grandPa).forEach((child) ->
                System.out.printf("%s %s\n", child.getFirst_name(), child.getLast_name()));
        // Находим родителей Семена Сидорова
        System.out.printf("%s %s's parents:\n", child_03.getFirst_name(), child_03.getLast_name());
        familyRelations.findParents(child_03).forEach((parent) ->
                System.out.printf("%s %s\n", parent.getFirst_name(), parent.getLast_name()));
        // Находим сестер/братьев Петра Иванова
        System.out.printf("%s %s's sisters/brothers:\n", parent_01.getFirst_name(), parent_01.getLast_name());
        familyRelations.findBrothersSisters(parent_01).forEach((person) ->
                System.out.printf("%s %s\n", person.getFirst_name(), person.getLast_name()));
    }
}

/*
    Output:
    Ivan Ivanov's children:
    Pyotr Ivanov
    Olga Ivanova
    Semyon Sidorov's parents:
    Olga Ivanova
    Vasily Sidorov
    Pyotr Ivanov's sisters/brothers:
    Olga Ivanova
 */