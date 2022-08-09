package com.Vegs;

import org.jetbrains.annotations.NotNull;

public abstract class Vegetable {
    private String name;
    private Color color;
    private int mass;

    protected static int vegs;

    static {
        vegs = 0;
    }

    protected void setMass(int mass) {
        this.mass = mass;
    }

    protected int getMass() {
        return this.mass;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getName() {
        return this.name;
    }

    protected void setColor(Color color) {
        this.color = color;
    }

    protected Color getColor() {
        return this.color;
    }

    protected void howManyVegs() {
        System.out.println(vegs);
    }

    protected void useProduct(int used) {
        this.mass -= used;
    }

    protected void cookMeals(@NotNull Vegetable vegAdd, int mainMass, int addedMass) {
        vegAdd.useProduct(addedMass);
        this.useProduct(mainMass);
        System.out.printf("Add %s %d to %s %d\n", vegAdd.name, addedMass, this.name, mainMass);
    }

}
