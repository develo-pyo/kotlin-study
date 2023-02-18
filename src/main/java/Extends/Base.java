package Extends;

public class Base {

    public int number = 100;

    public Base() {
        System.out.println("Base Constructor");
        System.out.println(number);             // base number
        System.out.println(this.getNumber());   // can be subclass's getNumber
    }

    public String test() {
        return "super class test() called";
    }
    public int getNumber() {
        System.out.println("Base getter!");
        return number;
    }
}
