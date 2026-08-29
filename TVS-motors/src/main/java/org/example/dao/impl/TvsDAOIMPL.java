package org.example.dao.impl;

import org.example.dao.TvsDAO;
import org.example.entity.TvsMotoresEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.*;
import java.util.List;

public class TvsDAOIMPL implements TvsDAO {
    @Override
    public boolean save(TvsMotoresEntity entity) {
        System.out.println("Running save in TvsDAOIMPL");
        boolean isSaved = false;
        if (entity != null) {

            EntityManagerFactory emf = null;
            EntityManager em = null;
            EntityTransaction et = null;
            try {
                emf = Persistence.createEntityManagerFactory("tvs");
                em = emf.createEntityManager();
                et = em.getTransaction();
                et.begin();
                em.persist(entity);
                et.commit();
                isSaved = true;
                System.out.println(entity);
                System.out.println("Data saved successfully in accounts table");


            } catch (PersistenceException e) {
                if (et != null && et.isActive()) {
                    et.rollback();
                }
                e.printStackTrace();
                isSaved = false;
            } finally {
                if (em != null) {
                    em.close();
                }

                if (emf != null) {
                    emf.close();
                }
            }
        }


            return isSaved;
        }

    @Override
    public boolean savess(List<TvsMotoresEntity> entities) {
        boolean isSaved = false;
        if (entities != null) {

            EntityManagerFactory emf = null;
            EntityManager em = null;
            EntityTransaction et = null;
            try {
                emf = Persistence.createEntityManagerFactory("tvs");
                em = emf.createEntityManager();
                et = em.getTransaction();
                et.begin();
                for (TvsMotoresEntity entity : entities) {
                    em.persist(entity);
                }
                et.commit();
                isSaved = true;
                System.out.println(entities);
                System.out.println("Data saved successfully in accounts table");


            } catch (PersistenceException e) {
                if (et != null && et.isActive()) {
                    et.rollback();
                }
                e.printStackTrace();
                isSaved = false;
            } finally {
                if (em != null) {
                    em.close();
                }

                if (emf != null) {
                    emf.close();
                }
            }
        }


        return isSaved;
    }

    @Override
    public TvsMotoresEntity getTvsMotoresEntity(Integer id) {
TvsMotoresEntity entity = null;
        EntityManagerFactory emf = null;
EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("tvs");

            em = emf.createEntityManager();

            entity = em.find(TvsMotoresEntity.class, id);




        } catch (PersistenceException p) {
            p.printStackTrace();

        } finally {
            if (emf != null) {
                emf.close();
            }
        }

        return entity;
    }
}

