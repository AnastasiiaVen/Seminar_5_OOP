package com.day07;

public class Program {
    public static void main(String[] args) {

        System.out.println("Cat was a pet");
        AnimalActionInjector injector = new CatActionInjector();
        HomePet pet = injector.getHomePet();
        pet.showAction();

        System.out.println("The cat is gone, the pet is now a dog");
        injector = new DogActionInjector();
        pet = injector.getHomePet();
        pet.showAction();

    }
}

/*
    Output:
    Cat was a pet
    Cat says Myau!
    The cat is gone, the pet is now a dog
    Dog says Gav!
 */