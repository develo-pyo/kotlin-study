package Extends;

public class Derived extends Base {

    public int number;

    public Derived(int number) {
        System.out.println("Derived constructor");
        this.number = number;
    }

    @Override
    public int getNumber(){
        System.out.println("Derived Getter");
        return number;
    }

    public static void main(String[] args) {
        Derived derived = new Derived(300);
        System.out.println(">>" + derived.getNumber());
        System.out.println(derived.test());
    }
}

