package com.bagas.challenge;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==========CALCULATOR==========");
        System.out.println("example: 1 + 2");
        String calc = sc.nextLine();
        String[] arr = calc.split(" ");
        System.out.println("= " + calculate(arr));
    }

    static int calculate(String[] arr) {
        switch (arr[1]) {
            case "+":
                return Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]);
            case "-":
                return Integer.parseInt(arr[0]) - Integer.parseInt(arr[2]);
            case "x":
                return Integer.parseInt(arr[0]) * Integer.parseInt(arr[2]);
            case ":":
                return Integer.parseInt(arr[0]) / Integer.parseInt(arr[2]);
            case "%":
                return Integer.parseInt(arr[0]) % Integer.parseInt(arr[2]);
            default:
                break;
        }
        return 0;
    }
}
