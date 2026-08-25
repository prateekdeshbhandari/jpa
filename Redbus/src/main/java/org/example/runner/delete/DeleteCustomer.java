package org.example.runner.delete;

import org.example.entity.BookingEntity;
import org.example.entity.CustomerEntity;

import javax.persistence.*;

public class DeleteCustomer {
    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("redbus");
            em = emf.createEntityManager();
            et = em.getTransaction();


            CustomerEntity entity = em.find(CustomerEntity.class, 1);

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