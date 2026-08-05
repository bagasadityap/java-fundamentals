package com.bagas.challenge;

public class Maths {
    public static void main(String[] args) {
        System.out.println("Circle : " + circle(10));
        System.out.println("Square Root :" + sqrtRoot(144));
        System.out.println("Pow :" + pow(2, 8));
    }

    static double circle(int r) {
        double result = Math.PI * sqrtRoot(r);
        return result;
    }

    static int sqrtRoot(int a) {
        return (int) Math.sqrt(a);
    }

    static double pow(int x, int y) {
        return Math.pow(x, y);
    }
}
