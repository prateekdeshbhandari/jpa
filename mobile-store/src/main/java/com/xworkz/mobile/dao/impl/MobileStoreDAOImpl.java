package com.xworkz.mobile.dao.impl;




import com.xworkz.mobile.dao.MobileStoreDAO;
import com.xworkz.mobile.entity.MobileStoreEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class MobileStoreDAOImpl implements MobileStoreDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("library");
    @Override
    public boolean save(MobileStoreEntity entity) {

        System.out.println("Running save in MobileStoreDAOImpl");

        boolean isSaved = false;

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("mobile");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            em.persist(entity);

            et.commit();

            isSaved = true;

            System.out.println(entity);
            System.out.println("Mobile data saved successfully");

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

        return isSaved;
    }


    @Override
    public boolean savess(List<MobileStoreEntity> entities) {

        boolean isSaved = false;

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("mobile");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            for (MobileStoreEntity entity : entities) {
                em.persist(entity);
            }

            et.commit();

            isSaved = true;

            System.out.println(entities);
            System.out.println("Multiple mobile data saved successfully");

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

        return isSaved;
    }


    @Override
    public MobileStoreEntity getMobileStoreEntity(Integer id) {

        MobileStoreEntity entity = null;

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mobile");

            em = emf.createEntityManager();

            entity = em.find(MobileStoreEntity.class, id);

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

    @Override
    public List<MobileStoreEntity> getAllMobileStores() {

        List<MobileStoreEntity> entities = Collections.emptyList();

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mobile");
            em = emf.createEntityManager();

            Query query = em.createNamedQuery("getAllMobileStores");

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
    public MobileStoreEntity getMobileStoreEntityByBrand(String brand) {

        MobileStoreEntity entity = null;
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mobile");
            em = emf.createEntityManager();

            Query query = em.createNamedQuery("findMobileStoreByBrand");

            query.setParameter("brand", brand);



            Object ref = query.getSingleResult();

            entity = (MobileStoreEntity) ref;

            System.out.println("" + ref);

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return entity;
    }


    @Override
    public MobileStoreEntity getMobileStoreEntityByIdAndMobileName(int id, String mobileName) {

        MobileStoreEntity entity = null;
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mobile");
            em = emf.createEntityManager();

            Query query = em.createNamedQuery("findMobileStoreByIdAndMobileName");

            query.setParameter("id", id);
            query.setParameter("mobileName", mobileName);


            Object ref = query.getSingleResult();

            entity = (MobileStoreEntity) ref;

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return entity;
    }


    @Override
    public List<MobileStoreEntity> getAllMobileStoresByIdAndColor(int id, String color) {

        List<MobileStoreEntity> entities = Collections.emptyList();

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mobile");
            em = emf.createEntityManager();

            Query query = em.createNamedQuery("findMobileStoreByIdAndColor");

            query.setParameter("id", id);
            query.setParameter("color", color);

            entities = query.getResultList();

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return entities;
    }


    @Override
    public List<MobileStoreEntity> getAllMobileStoresByPriceAndBrand(double price, String brand) {

        List<MobileStoreEntity> entities = Collections.emptyList();

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mobile");
            em = emf.createEntityManager();

            Query query = em.createNamedQuery("findMobileStoreByPriceAndBrand");

            query.setParameter("price", price);
            query.setParameter("brand", brand);

            entities = query.getResultList();

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public Boolean updateMobileNameAndBrand(int id, String mobileName, String brand) {

        Boolean isUpdated = false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {

            em = emf.createEntityManager();

            et = em.getTransaction();
            et.begin();

            Query query = em.createQuery("UPDATE MobileStoreEntity m " + "SET m.mobileName = :mobileName, m.brand = :brand " + "WHERE m.id = :id");

            query.setParameter("id", id);
            query.setParameter("mobileName", mobileName);
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
    public Boolean updateMobileNameUsingID(int id, String mobileName) {

        Boolean isUpdated = false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {

            em = emf.createEntityManager();

            et = em.getTransaction();
            et.begin();

            Query query = em.createQuery("UPDATE MobileStoreEntity m " + "SET m.mobileName = :mobileName " + "WHERE m.id = :id");
            query.setParameter("id", id);
            query.setParameter("mobileName", mobileName);

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
    public Boolean updateMobileColorUsingID(int id, String color) {

        Boolean isUpdated = false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {

            em = emf.createEntityManager();

            et = em.getTransaction();
            et.begin();

            Query query = em.createQuery("UPDATE MobileStoreEntity m " + "SET m.color = :color " + "WHERE m.id = :id");

            query.setParameter("id", id);
            query.setParameter("color", color);

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
    public List<String> getMobileName() {
        List<String>listname=Collections.emptyList();
        try {
            {
                listname  =emf.createEntityManager().createQuery("select r.mobileStoreName from MobileStoreEntity r").getResultList();
            }

        }catch (PersistenceException e){
            e.printStackTrace();
        }
        return listname;
    }

    @Override
    public List<Object> getBrand() {
        List<Object>listname=Collections.emptyList();
        try {
            {
                listname  =emf.createEntityManager().createQuery("select r.brand from MobileStoreEntity r").getResultList();
            }

        }catch (PersistenceException e){
            e.printStackTrace();
        }
        return listname;
    }
}
