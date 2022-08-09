package com.Vegs;

public class Vegetables {
    public static void main(String[] args) {
        Vegetable redTomato = new Tomato();
        Vegetable yellowTomato = new Tomato(Color.YELLOW, 200, 7);
        Vegetable simpleCucumber = new Cucumber(10, 250);

        System.out.println(redTomato);
        System.out.println(yellowTomato);
        System.out.println(simpleCucumber);

        redTomato.cookMeals(simpleCucumber, 100, 50);

        System.out.println(redTomato);
        System.out.println(simpleCucumber);

        simpleCucumber.cookMeals(yellowTomato, 90, 80);

        System.out.println(simpleCucumber);
        System.out.println(yellowTomato);

        redTomato.howManyVegs();
        yellowTomato.howManyVegs();
        simpleCucumber.howManyVegs();

    }
}
