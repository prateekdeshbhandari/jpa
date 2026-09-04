package org.example.dao.impl;

import org.example.dao.TvsDAO;
import org.example.entity.TvsMotoresEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class TvsDAOIMPL implements TvsDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("library");
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

    @Override
    public List<TvsMotoresEntity> getAllTvs() {

        List<TvsMotoresEntity> entities = Collections.emptyList();

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("tvs");
            em = emf.createEntityManager();

            Query query = em.createNamedQuery("getAllTvs");

            entities = query.getResultList();

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

        return entities;
    }

    @Override
    public TvsMotoresEntity getTvsMotorsEntityByBrand(String brand) {

        TvsMotoresEntity entity = null;
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("tvs");
            em = emf.createEntityManager();

            Query query = em.createNamedQuery("findTvsMotorsByBrand");

            query.setParameter("brand", brand);



            Object ref = query.getSingleResult();

            entity = (TvsMotoresEntity) ref;

            System.out.println("" + ref);

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return entity;
    }


    @Override
    public TvsMotoresEntity getTvsMotorsEntityByIdAndModelName(int id, String modelName) {

        TvsMotoresEntity entity = null;
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("tvs");
            em = emf.createEntityManager();

            Query query = em.createNamedQuery("findTvsMotorsByIdAndModelName");

            query.setParameter("id", id);
            query.setParameter("modelName", modelName);



            Object ref = query.getSingleResult();

            entity = (TvsMotoresEntity) ref;

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return entity;
    }


    @Override
    public List<TvsMotoresEntity> getAllTvsByIdAndCategory(int id, String category) {
        List<TvsMotoresEntity> entities = Collections.emptyList();

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("tvs");
            em = emf.createEntityManager();

            Query query = em.createNamedQuery(
                            "findTvsMotorsByIdAndCategory");
            query.setParameter("id", id);
            query.setParameter("category", category);

            entities = query.getResultList();

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return entities;
    }


    @Override
    public List<TvsMotoresEntity> getAllTvsByPriceAndBrand(double price, String brand) {
        List<TvsMotoresEntity> entities = Collections.emptyList();

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("tvs");
            em = emf.createEntityManager();

            Query query = em.createNamedQuery("findTvsMotorsByPriceAndBrand");

            query.setParameter("price", price);
            query.setParameter("brand", brand);

            entities = query.getResultList();

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public Boolean updateTvsNameAndBrand(Integer id, String name, String brand) {

        Boolean isUpdated = false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {

            em = emf.createEntityManager();

            et = em.getTransaction();
            et.begin();

            Query query = em.createQuery(
                    "UPDATE TvsMotorsEntity t " +
                            "SET t.name = :name, t.brand = :brand " +
                            "WHERE t.id = :id"
            );

            query.setParameter("id", id);
            query.setParameter("name", name);
            query.setParameter("brand", brand);

            int result = query.executeUpdate();

            if (result > 0) {
                isUpdated = true;
            }

            et.commit();

        } catch (PersistenceException e) {

            if (et != null && et.isActive()) {
                et.rollback();
            }

            e.printStackTrace();

        } finally {

            if (em != null) {
                em.close();
            }
        }

        return isUpdated;
    }


    @Override
    public Boolean updateTvsNameUsingID(Integer id, String name) {

        Boolean isUpdated = false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {

            em = emf.createEntityManager();

            et = em.getTransaction();
            et.begin();

            Query query = em.createQuery(
                    "UPDATE TvsMotorsEntity t " +
                            "SET t.name = :name " +
                            "WHERE t.id = :id"
            );

            query.setParameter("id", id);
            query.setParameter("name", name);

            int result = query.executeUpdate();

            if (result > 0) {
                isUpdated = true;
            }

            et.commit();

        } catch (PersistenceException e) {

            if (et != null && et.isActive()) {
                et.rollback();
            }

            e.printStackTrace();

        } finally {

            if (em != null) {
                em.close();
            }
        }

        return isUpdated;
    }


    @Override
    public Boolean updateTvsTypeUsingID(Integer id, String type) {

        Boolean isUpdated = false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {

            em = emf.createEntityManager();

            et = em.getTransaction();
            et.begin();

            Query query = em.createQuery(
                    "UPDATE TvsMotorsEntity t " +
                            "SET t.type = :type " +
                            "WHERE t.id = :id"
            );

            query.setParameter("id", id);
            query.setParameter("type", type);

            int result = query.executeUpdate();

            if (result > 0) {
                isUpdated = true;
            }

            et.commit();

        } catch (PersistenceException e) {

            if (et != null && et.isActive()) {
                et.rollback();
            }

            e.printStackTrace();

        } finally {

            if (em != null) {
                em.close();
            }
        }

        return isUpdated;
    }

    @Override
    public List<String> getModelName() {
        List<String>listname=Collections.emptyList();
        try {
            {
                listname  =emf.createEntityManager().createQuery("select r.modelName from TvsMotoresEntity r").getResultList();
            }

        }catch (PersistenceException e){
            e.printStackTrace();
        }
        return listname;
    }

    @Override
    public List<Object> getCategory() {
        List<Object>listname=Collections.emptyList();
        try {
            {
                listname  =emf.createEntityManager().createQuery("select r.category from TvsMotoresEntity r").getResultList();
            }

        }catch (PersistenceException e){
            e.printStackTrace();
        }
        return listname;
    }
}

