package com.xwork.Bank.dao.impl;

import com.xwork.Bank.dao.DebitAccountDAO;
import com.xwork.Bank.entity.DebitAccountEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class DebitAccountDAOImpl implements DebitAccountDAO {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("library");
    @Override
    public boolean save(DebitAccountEntity entity) {

        System.out.println("Running save in DebitAccountDAOImpl");

        boolean isSaved = false;

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("debit");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            em.persist(entity);

            et.commit();

            isSaved = true;

            System.out.println(entity);
            System.out.println("Debit account data saved successfully");

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
    public boolean savess(List<DebitAccountEntity> entities) {

        boolean isSaved = false;

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("debit");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            for (DebitAccountEntity entity : entities) {
                em.persist(entity);
            }

            et.commit();

            isSaved = true;

            System.out.println(entities);
            System.out.println("Multiple debit account data saved successfully");

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
    public DebitAccountEntity getDebitAccountEntity(Integer id) {

        DebitAccountEntity entity = null;

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("debit");

            em = emf.createEntityManager();

            entity = em.find(DebitAccountEntity.class, id);

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
    public List<DebitAccountEntity> getAllDebitAccounts() {

        List<DebitAccountEntity> entities = Collections.emptyList();

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("bank");
            em = emf.createEntityManager();

            Query query = em.createNamedQuery("getAllDebitAccounts");

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
    public DebitAccountEntity getDebitAccountEntityByName(String name) {

        DebitAccountEntity entity = null;
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("bank");
            em = emf.createEntityManager();

            Query query = em.createNamedQuery("findDebitAccountByName");

            query.setParameter("name", name);


            Object ref = query.getSingleResult();

            entity = (DebitAccountEntity) ref;

            System.out.println("" + ref);

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return entity;
    }


    @Override
    public DebitAccountEntity getDebitAccountEntityByIdAndName(
            int id,
            String name) {

        DebitAccountEntity entity = null;
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("bank");
            em = emf.createEntityManager();

            Query query = em.createNamedQuery("findDebitAccountByIdAndName");

            query.setParameter("id", id);
            query.setParameter("name", name);


            Object ref = query.getSingleResult();

            entity = (DebitAccountEntity) ref;

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return entity;
    }


    @Override
    public List<DebitAccountEntity> getAllDebitAccountsByIdAndBankName(
            int id,
            String bankName) {

        List<DebitAccountEntity> entities =
                Collections.emptyList();

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("bank");
            em = emf.createEntityManager();

            Query query = em.createNamedQuery("findDebitAccountByIdAndBankName");

            query.setParameter("id", id);
            query.setParameter("bankName", bankName);

            entities = query.getResultList();

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return entities;
    }


    @Override
    public List<DebitAccountEntity> getAllDebitAccountsByBalanceAndName(
            double balance,
            String name) {

        List<DebitAccountEntity> entities =
                Collections.emptyList();

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("bank");
            em = emf.createEntityManager();

            Query query = em.createNamedQuery("findDebitAccountByBalanceAndName");

            query.setParameter("balance", balance);
            query.setParameter("name", name);

            entities = query.getResultList();

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public Boolean updateDebitAccountNameAndBank(int id, String name, String bankName) {

        Boolean isUpdated = false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {

            em = emf.createEntityManager();

            et = em.getTransaction();
            et.begin();

            Query query = em.createQuery("UPDATE DebitAccountEntity d " + "SET d.name = :name, d.bankName = :bankName " + "WHERE d.id = :id");

            query.setParameter("id", id);
            query.setParameter("name", name);
            query.setParameter("bankName", bankName);

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
    public Boolean updateDebitAccountNameUsingID(int id, String name) {

        Boolean isUpdated = false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {

            em = emf.createEntityManager();

            et = em.getTransaction();
            et.begin();

            Query query = em.createQuery("UPDATE DebitAccountEntity d " + "SET d.name = :name " + "WHERE d.id = :id");

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
    public Boolean updateDebitAccountBankUsingID(int id, String bankName) {

        Boolean isUpdated = false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {

            em = emf.createEntityManager();

            et = em.getTransaction();
            et.begin();

            Query query = em.createQuery("UPDATE DebitAccountEntity d " + "SET d.bankName = :bankName " + "WHERE d.id = :id");

            query.setParameter("id", id);
            query.setParameter("bankName", bankName);

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
}
