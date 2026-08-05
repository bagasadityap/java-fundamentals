package com.bagas.challenge;

import java.util.Scanner;

public class Operators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Pilih operator + | - | x | : | % | ... ");
        String operator = sc.nextLine();
        System.out.println("Masukkan angka pertama: ");
        int a = sc.nextInt();
        sc.nextLine();
        System.out.println("Masukkan angka kedua: ");
        int b = sc.nextInt();
        sc.nextLine();

        switch (operator) {
            case "+":
                System.out.println(sum(a,b));
                break;
            case "-":
                System.out.println(min(a,b));
                break;
            case "x":
                System.out.println(multiple(a,b));
                break;
            case ":":
                System.out.println(division(a,b));
                break;
            case "%":
                System.out.println(modulo(a,b));
                break;
            default:
                break;
        }
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int min(int a, int b) {
        return a - b;
    }

    public static double division(double a, double b) {
        return a/b;
    }

    public static int modulo(int a, int b) {
        return a%b;
    }

    public static int multiple(int a, int b) {
        return a*b;
    }
}
