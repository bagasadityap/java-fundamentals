package com.bagas.exercises.repository;

import com.bagas.exercises.entity.Training;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static com.bagas.exercises.util.RepositoryUtil.executeInTransaction;

public class TrainingRepository {
    private final SessionFactory sessionFactory;

    public TrainingRepository (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Training save (Training training) {
        return executeInTransaction(session -> {
            session.persist(training);
            return training;
        });
    }

    public Optional<Training> findById(Long id) {
        return executeInTransaction(session -> {
            return Optional.ofNullable(
                    session.find(Training.class, id)
            );
        });
    }

    public List<Training> findAll() {
        return executeInTransaction(session ->
                session.createSelectionQuery(
                        "from Training",
                        Training.class
                ).getResultList()
        );
    }

    public Training update(Training training) {
        return executeInTransaction(session ->
                session.merge(training)
        );
    }

    public boolean deleteById(Long id) {
        return executeInTransaction(session -> {
            Training training = session.find(Training.class, id);

            if (training == null) {
                return false;
            }

            session.remove(training);
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
