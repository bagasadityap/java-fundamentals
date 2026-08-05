package com.bagas.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Branching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isRegistered = false;
        String[] registeredLog = new String[]{"AA12345", "B10912893", "A2123123", "B2123123"};

        for (int i = 1; i > 0; i++) {
            System.out.println("Pilih Menu: 1. Cek Log | 2. Cari Log | 3. Tampilkan Semua | 0. Exit");
            int menu = sc.nextInt();
            sc.nextLine();

            if (menu == 1) {
                System.out.print("Cek log: ");
                String log = sc.nextLine();
                isRegistered = isRegistered(registeredLog, log);

                if (!isRegistered) {
                    System.out.println("Log belum diregister");
                } else {
                    System.out.println("Log " + log + " sudah diregistrasi");
                }
            } else if (menu == 2) {
                System.out.print("Cari log: ");
                String log = sc.nextLine();
                String[] res = search(registeredLog, log).toArray(new String[0]);

                if (res.length > 0) {
                    System.out.println(Arrays.toString(res));
                } else {
                    System.out.println("Data tidak ditemukan");
                }
            } else if (menu == 3) {
                System.out.println(Arrays.toString(registeredLog));
            } else if (menu == 0) {
                break;
            } else {
                System.out.println("Input Salah");
            }
        }

    }

    public static boolean isRegistered(String[] reg, String log) {
        for (int i = 0; i < reg.length; i++) {
            if (reg[i].equalsIgnoreCase(log)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<String>  search(String[] reg, String log) {
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < reg.length; i++) {
            if (reg[i].contains(log)) {
                result.add(reg[i]);
            }
        }

        return result;
    }
}
