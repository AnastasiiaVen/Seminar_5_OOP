package com.StreamAPI;

public abstract class Content {
    protected String name;

    public Content(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
