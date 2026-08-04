package oop;

public class Duck extends Animal implements Flyable {
    @Override
    public void move() {
        System.out.println("berenang");
    }

    @Override
    public void sound() {
        System.out.println("kwek kwek");
    }

    @Override
    public void flying() {
        System.out.println("yeee bisa terbang");
    }

    @Override
    public void eat() {
        System.out.println("aku makan jagung");
    }
}
