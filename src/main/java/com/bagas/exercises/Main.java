package com.bagas.exercises;

import com.bagas.exercises.entity.Karyawan;
import com.bagas.exercises.repository.KaryawanRepository;
import com.bagas.exercises.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Scanner sc = new Scanner(System.in);

        System.out.println("Masukkan nama: ");
        String nama = sc.nextLine();
        System.out.println("Masukkan alamat: ");
        String alamat = sc.nextLine();
        System.out.println("Masukkan tanggal lahir: ");
        String dob = sc.nextLine();

        Karyawan karyawan = inputKaryawan(nama, alamat, dob);

        karyawanRepository(sessionFactory, karyawan);
    }

    public static void karyawanRepository(SessionFactory sessionFactory, Karyawan karyawan) {
        KaryawanRepository karyawanRepository = new KaryawanRepository(sessionFactory);
        karyawanRepository.findAll();

        karyawanRepository.save(karyawan);
    }

    public static Karyawan inputKaryawan(String nama, String alamat, String dob) {
        Karyawan karyawan = new Karyawan();
        karyawan.setNama(nama);
        karyawan.setAlamat(alamat);
        karyawan.setDob(LocalDate.parse(dob));
        karyawan.setStatus(true);
        karyawan.setCreatedDate(LocalDateTime.now());

        return karyawan;
    }
}
