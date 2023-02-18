package Implements;

public interface Flyable {
    default void act() {
        System.out.println("난다");
    }
}
