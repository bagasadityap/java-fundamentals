package com.bagas.challenge;

import java.util.Scanner;

public class Profile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan nama anda: ");
        String nama = sc.nextLine();
        System.out.print("Masukkan alamat anda: ");
        String alamat = sc.nextLine();
        System.out.print("Masukkan umur anda: ");
        int umur = sc.nextInt();

        showMyProfile(nama, alamat, umur);
    }

    public static void showMyProfile(String nama, String alamat, int umur) {
        System.out.println("===== Biodata =====");
        System.out.println("Nama \t: " + nama);
        System.out.println("Alamat \t: " + alamat);
        System.out.println("Umur \t: " + umur);
        System.out.println("===== ===== =====");
    }
}
