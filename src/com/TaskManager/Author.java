package com.TaskManager;

import java.util.UUID;

public class Author {
    private final UUID authorID;
    private final String name;
    private final String surname;
    private String comment;

    public Author(String name, String surname, String comment) {
        this.authorID = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.comment = comment;
    }

    public Author(String name, String surname) {
        this(name, surname, "Add comment here");
    }

    public UUID getAuthorID() {
        return authorID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return String.format("%s %s", name, surname);
    }
}
