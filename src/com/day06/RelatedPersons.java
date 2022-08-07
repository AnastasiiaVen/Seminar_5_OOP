package com.day06;

public abstract class RelatedPersons {
    protected final Person first_person;
    protected final Person second_person;

    protected RelatedPersons(Person first_person, Person second_person) {
        this.first_person = first_person;
        this.second_person = second_person;
    }
}

