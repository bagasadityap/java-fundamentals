package com.bagas.challenge;

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan angka: ");
        int number = sc.nextInt();

        if (number % 3 == 0 && number % 5 == 0) {
            System.out.println("Fizz Buzz");
        } else if (number % 3 == 0) {
            System.out.println("Fizz");
        } else if (number % 5 == 0) {
            System.out.println("Buzz");
        }
    }
}
