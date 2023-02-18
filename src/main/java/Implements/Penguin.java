package Implements;

public class Penguin implements Swimable, Flyable{

    @Override
    public void act() {
        Swimable.super.act();
        Flyable.super.act();
    }
}
