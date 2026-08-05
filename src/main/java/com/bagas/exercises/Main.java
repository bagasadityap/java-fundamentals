package com.bagas.exercises;

import com.bagas.exercises.entity.Karyawan;
import com.bagas.exercises.repository.KaryawanRepository;
import com.bagas.exercises.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        karyawanRepository(sessionFactory);
    }

    public static void karyawanRepository(SessionFactory sessionFactory) {
        KaryawanRepository karyawanRepository = new KaryawanRepository(sessionFactory);
        karyawanRepository.findAll();

        Karyawan karyawan = new Karyawan();
        karyawan.setNama("Bagas");
        karyawan.setAlamat("Malang");
        karyawan.setDob(LocalDate.parse("1998-01-10"));
        karyawan.setStatus(true);

        karyawanRepository.save(karyawan);
    }
}
