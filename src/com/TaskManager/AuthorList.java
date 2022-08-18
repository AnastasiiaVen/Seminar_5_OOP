package com.TaskManager;

import java.util.ArrayList;
import java.util.UUID;

public class AuthorList {
    private ArrayList<Author> authorList = null;

    public AuthorList() {
        this.authorList = new ArrayList<>();
    }

    public ArrayList<Author> getAuthorList() {
        return authorList;
    }

    public void add(String name, String surname) {
        authorList.add(new Author(name, surname));
    }

    public UUID getAuthor(String name, String surname) {
        for (Author author : authorList) {
            if (author.getName().equals(name) && author.getSurname().equals(surname)) {
                return author.getAuthorID();
            }
        }
        return null;
    }

}
