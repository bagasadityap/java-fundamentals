package com.bagas.exercises.repository;

import com.bagas.exercises.entity.DetailKaryawan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static com.bagas.exercises.util.RepositoryUtil.executeInTransaction;

public class DetailKaryawanRepository {
    private final SessionFactory sessionFactory;

    public DetailKaryawanRepository (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public DetailKaryawan save (DetailKaryawan detailKaryawan) {
        return executeInTransaction(session -> {
            session.persist(detailKaryawan);
            return detailKaryawan;
        });
    }

    public Optional<DetailKaryawan> findById(Long id) {
        return executeInTransaction(session -> {
            return Optional.ofNullable(
                    session.find(DetailKaryawan.class, id)
            );
        });
    }

    public List<DetailKaryawan> findAll() {
        return executeInTransaction(session ->
                session.createSelectionQuery(
                        "from DetailKaryawan",
                        DetailKaryawan.class
                ).getResultList()
        );
    }

    public DetailKaryawan update(DetailKaryawan detailKaryawan) {
        return executeInTransaction(session ->
                session.merge(detailKaryawan)
        );
    }

    public boolean deleteById(Long id) {
        return executeInTransaction(session -> {
            DetailKaryawan detailKaryawan = session.find(DetailKaryawan.class, id);

            if (detailKaryawan == null) {
                return false;
            }

            session.remove(detailKaryawan);
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
