package com.bagas.exercises.util;


import com.bagas.exercises.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public final class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY =
            buildSessionFactory();

    // Utility class tidak boleh diinstansiasi.
    private HibernateUtil() {

    }

    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .loadProperties("hibernate.properties")
                        .build();

        try {
            return new MetadataSources(registry)
                    .addAnnotatedClass(Karyawan.class)
                    .addAnnotatedClass(DetailKaryawan.class)
                    .addAnnotatedClass(Rekening.class)
                    .addAnnotatedClass(Training.class)
                    .addAnnotatedClass(KaryawanTraining.class)
                    .buildMetadata()
                    .buildSessionFactory();

        } catch (RuntimeException exception) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw exception;
        }
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public static void shutdown() {
        if (!SESSION_FACTORY.isClosed()) {
            SESSION_FACTORY.close();
        }
    }
}