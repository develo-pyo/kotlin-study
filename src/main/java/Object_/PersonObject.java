package Object_;

public class PersonObject {
    private static final int MIN_AGE = 1;

    public static PersonObject newBaby(String name) {
        return new PersonObject(name, MIN_AGE);
    }

    private String name;
    private int age;

    private PersonObject(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
