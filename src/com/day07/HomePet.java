package com.day07;

public class HomePet {

    // Абстрактное действие животного
    private AnimalAction action;

    /* В конструктор передаем через конкретный инжектор
        реализацию конкретного животного.
        Из клиентского кода для Кота:
        AnimalActionInjector injector = new CatActionInjector();
        HomePet pet = injector.getHomePet();
        Через инжектор
        return new HomePet(new CatImpl());
    */
    public HomePet(AnimalAction act) {
        this.action = act;
    }

    public void showAction(){
        this.action.animalSays();
    }
}
