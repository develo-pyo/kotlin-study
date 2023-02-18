package Implements;

public interface Swimable {
    default void act() {
        System.out.println("수영한다");
    }
}
