package com.Vegs;

public class Tomato extends Vegetable {

    private int diameter;
    public Tomato(Color color, int mass, int diameter) {
        super.setName("tomato");
        super.setColor(color);
        super.setMass(mass);
        this.diameter = diameter;
        vegs++;
    }

    public Tomato() {
        this(Color.RED, 100, 8);
    }

    @Override
    public String toString(){
        return String.format("This %s is %s, diameter = %d, mass = %d",
                getName(), getColor().toString(), diameter, getMass());
    }
}
