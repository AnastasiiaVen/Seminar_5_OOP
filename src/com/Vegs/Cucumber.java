package com.Vegs;

public class Cucumber extends Vegetable{
    private int lenght;
    public Cucumber(int lenght, int mass){
        super.setName("cucumber");
        super.setColor(Color.GREEN);
        super.setMass(mass);
        this.lenght = lenght;
        vegs++;
    }

    @Override
    public String toString(){
        return String.format("This %s is %s, lenght = %d, mass = %d",
                getName(), getColor().toString(), lenght, getMass());
    }
}
