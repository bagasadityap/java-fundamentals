package com.bagas.exercises.repository;

import com.bagas.exercises.entity.Karyawan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static com.bagas.exercises.util.RepositoryUtil.executeInTransaction;

public class KaryawanRepository {
    private final SessionFactory sessionFactory;

    public KaryawanRepository (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Karyawan save (Karyawan karyawan) {
        return executeInTransaction(session -> {
            session.persist(karyawan);
            return karyawan;
        });
    }

    public Optional<Karyawan> findById(Long id) {
        return executeInTransaction(session -> {
            return Optional.ofNullable(
                    session.find(Karyawan.class, id)
            );
        });
    }

    public List<Karyawan> findAll() {
        return executeInTransaction(session ->
                session.createSelectionQuery(
                        "from Karyawan",
                        Karyawan.class
                ).getResultList()
        );
    }

    public Karyawan update(Karyawan karyawan) {
        return executeInTransaction(session ->
                session.merge(karyawan)
        );
    }

    public boolean deleteById(Long id) {
        return executeInTransaction(session -> {
            Karyawan karyawan = session.find(Karyawan.class, id);

            if (karyawan == null) {
                return false;
            }

            session.remove(karyawan);
            return true;
        });
    }

    private <T> T executeInTransaction(
            Function<Session,T> operation
    ) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                T result = operation.apply(session);
                transaction.commit();

                return result;

            } catch (RuntimeException exception) {
                rollback(transaction);
                throw exception;
            }
        }
    }

    private void rollback(Transaction transaction) {
        if (transaction != null && transaction.isActive()) {
            transaction.rollback();
        }
    }
}
