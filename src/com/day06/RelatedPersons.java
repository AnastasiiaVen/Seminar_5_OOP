package com.day06;

public abstract class RelatedPersons {
    protected final Pers first_pers;
    protected final Pers second_pers;

    protected RelatedPersons(Pers first_pers, Pers second_pers) {
        this.first_pers = first_pers;
        this.second_pers = second_pers;
    }
}

