package com.day07;

public class CatActionInjector implements AnimalActionInjector{

    @Override
    public HomePet getHomePet() {
        return new HomePet(new CatImpl());
    }

}
