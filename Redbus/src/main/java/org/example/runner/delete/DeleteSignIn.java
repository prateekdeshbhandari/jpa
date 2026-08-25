package org.example.runner.delete;

import org.example.entity.BookingEntity;
import org.example.entity.SignInEntity;

import javax.persistence.*;

public class DeleteSignIn {
    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("redbus");
            em = emf.createEntityManager();
            et = em.getTransaction();


            SignInEntity entity = em.find(SignInEntity.class, 1);

            if (entity != null) {
                et.begin();
                em.remove(entity);
                et.commit();
                System.out.println("Data Deleted");
            }

        } catch (PersistenceException e) {
            e.printStackTrace();
            et.rollback();


        } finally {
            if (emf != null) {
                emf.close();
            }
            if (em != null) {
                em.close();
            }
        }
    }
}