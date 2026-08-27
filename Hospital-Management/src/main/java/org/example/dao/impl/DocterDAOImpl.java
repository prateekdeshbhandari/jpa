package org.example.dao.impl;

import org.example.Entity.DocterEntity;
import org.example.dao.DocterDAO;

import javax.persistence.*;
import java.util.List;

public class DocterDAOImpl implements DocterDAO {
    @Override
    public boolean save(DocterEntity entity) {

        System.out.println("Running save in DocterDAOIMPL");

        boolean isSaved = false;

        if (entity != null) {

            EntityManagerFactory emf = null;
            EntityManager em = null;
            EntityTransaction et = null;

            try {
                emf = Persistence.createEntityManagerFactory("docter");
                em = emf.createEntityManager();

                et = em.getTransaction();
                et.begin();

                em.persist(entity);

                et.commit();

                isSaved = true;

                System.out.println(entity);
                System.out.println("Doctor data saved successfully");

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
    public boolean savess(List<DocterEntity> entities) {

        boolean isSaved = false;

        if (entities != null && !entities.isEmpty()) {

            EntityManagerFactory emf = null;
            EntityManager em = null;
            EntityTransaction et = null;

            try {
                emf = Persistence.createEntityManagerFactory("docter");
                em = emf.createEntityManager();

                et = em.getTransaction();
                et.begin();

                for (DocterEntity entity : entities) {
                    em.persist(entity);
                }

                et.commit();

                isSaved = true;

                System.out.println(entities);
                System.out.println("Doctor data saved successfully");

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
    public DocterEntity getDocterEntity(Integer id) {

        DocterEntity entity = null;

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("docter");
            em = emf.createEntityManager();

            entity = em.find(DocterEntity.class, id);

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

            if (em != null) {
                em.close();
            }

            if (emf != null) {
                emf.close();
            }
        }

        return entity;
    }
}
