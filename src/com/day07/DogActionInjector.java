package com.day07;

public class DogActionInjector implements AnimalActionInjector{

    @Override
    public HomePet getHomePet() {
        return new HomePet(new DogImpl());
    }
}
