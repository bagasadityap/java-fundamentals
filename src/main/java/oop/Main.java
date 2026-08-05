package oop;

public class Main {
    static void main() {
        Duck duck = new Duck();
        Animal goat = new Goat();

        duck.move();
        duck.sound();
        System.out.println("\n");
        goat.move();
        goat.sound();
    }
}
