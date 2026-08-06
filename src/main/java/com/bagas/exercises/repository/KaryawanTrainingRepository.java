package com.bagas.exercises.repository;

import com.bagas.exercises.entity.KaryawanTraining;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static com.bagas.exercises.util.RepositoryUtil.executeInTransaction;

public class KaryawanTrainingRepository {
    private final SessionFactory sessionFactory;

    public KaryawanTrainingRepository (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public KaryawanTraining save (KaryawanTraining karyawanTraining) {
        return executeInTransaction(session -> {
            session.persist(karyawanTraining);
            return karyawanTraining;
        });
    }

    public Optional<KaryawanTraining> findById(Long id) {
        return executeInTransaction(session -> {
            return Optional.ofNullable(
                    session.find(KaryawanTraining.class, id)
            );
        });
    }

    public List<KaryawanTraining> findAll() {
        return executeInTransaction(session ->
                session.createSelectionQuery(
                        "from KaryawanTraining",
                        KaryawanTraining.class
                ).getResultList()
        );
    }

    public KaryawanTraining update(KaryawanTraining karyawanTraining) {
        return executeInTransaction(session ->
                session.merge(karyawanTraining)
        );
    }

    public boolean deleteById(Long id) {
        return executeInTransaction(session -> {
            KaryawanTraining karyawanTraining = session.find(KaryawanTraining.class, id);

            if (karyawanTraining == null) {
                return false;
            }

            session.remove(karyawanTraining);
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
