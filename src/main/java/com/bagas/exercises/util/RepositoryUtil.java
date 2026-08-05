package com.bagas.exercises.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.function.Function;

public class RepositoryUtil {



    public static  <T> T executeInTransaction(
            Function<Session, T> operation
    ) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                T result = operation.apply(session);
                transaction.commit();

                return result;

            } catch (RuntimeException exception) {
                transaction.rollback();
                throw exception;
            }
        }
    }
}