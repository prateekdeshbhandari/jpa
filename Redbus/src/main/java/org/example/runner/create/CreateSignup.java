package org.example.runner.create;


import org.example.entity.SingUpEntity;

import javax.persistence.*;

public class CreateSignup {

    public static void main(String[] args) {

        SingUpEntity entity = new SingUpEntity();
entity.setId(1);
entity.setPassword("123prateek");
        entity.setEmail("prateek@gmail.com");
        entity.setName("prateek");


        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {

            emf = Persistence.createEntityManagerFactory("redbus");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(entity);
            et.commit();

            System.out.println("Data saved successfully:" +entity);


        } catch (PersistenceException e) {

            if (et != null && et.isActive()) {
                et.rollback();
            }

            e.printStackTrace();

        } finally {

            if (em != null) {
                em.close();
            }

            if (emf != null) {
                emf.close();
            }
        }
    }
}