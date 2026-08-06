package com.bagas.exercises.repository;

import com.bagas.exercises.entity.Rekening;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static com.bagas.exercises.util.RepositoryUtil.executeInTransaction;

public class RekeningRepository {
    private final SessionFactory sessionFactory;

    public RekeningRepository (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Rekening save (Rekening rekening) {
        return executeInTransaction(session -> {
            session.persist(rekening);
            return rekening;
        });
    }

    public Optional<Rekening> findById(Long id) {
        return executeInTransaction(session -> {
            return Optional.ofNullable(
                    session.find(Rekening.class, id)
            );
        });
    }

    public List<Rekening> findAll() {
        return executeInTransaction(session ->
                session.createSelectionQuery(
                        "from Rekening",
                        Rekening.class
                ).getResultList()
        );
    }

    public Rekening update(Rekening rekening) {
        return executeInTransaction(session ->
                session.merge(rekening)
        );
    }

    public boolean deleteById(Long id) {
        return executeInTransaction(session -> {
            Rekening rekening = session.find(Rekening.class, id);

            if (rekening == null) {
                return false;
            }

            session.remove(rekening);
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
