package com.day09;


public class FamilyTree {
    public static void main(String[] args) {

        Family family = new Family();
        FillFamily.fillPersons(family, "src/com/day09/persons.txt");
        FillFamily.fillRelations(family, "src/com/day09/relations.txt");

        System.out.println("-----------------------");
        System.out.println("Persons sorted by age:");
        family.getFamily().stream().sorted(new HumanComparator()).forEach(System.out::println);

        Research research = new Research();

        System.out.println("-----------------------");
        System.out.println("Xenia Onatopp children:");
        research.findChildren(family, "Xenia", "Onatopp").forEach(System.out::println);

        System.out.println("-----------------------");
        System.out.println("Semyon Sidorov parents:");
        research.findParents(family, "Semyon", "Sidorov").forEach(System.out::println);

        System.out.println("-----------------------");
        System.out.println("Olga Ivanova brothers and sisters:");
        research.findBrothersSisters(family, "Olga", "Ivanova").forEach(System.out::println);

    }
}

/*
    Output:
    -----------------------
    Persons sorted by age:
    Name: Sergey, surname: Ivanov, age: 12
    Name: Mary, surname: Ivanova, age: 13
    Name: Semyon, surname: Sidorov, age: 14
    Name: Pyotr, surname: Ivanov, age: 35
    Name: Ann, surname: Petrova, age: 36
    Name: Olga, surname: Ivanova, age: 37
    Name: Vasily, surname: Sidorov, age: 38
    Name: Ivan, surname: Ivanov, age: 65
    Name: Xenia, surname: Onatopp, age: 65
    -----------------------
    Xenia Onatopp children:
    Name: Pyotr, surname: Ivanov, age: 35
    Name: Olga, surname: Ivanova, age: 37
    -----------------------
    Semyon Sidorov parents:
    Name: Olga, surname: Ivanova, age: 37
    Name: Vasily, surname: Sidorov, age: 38
    -----------------------
    Olga Ivanova brothers and sisters:
    Name: Pyotr, surname: Ivanov, age: 35
 */