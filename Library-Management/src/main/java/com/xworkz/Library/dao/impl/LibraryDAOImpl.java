package com.xworkz.Library.dao.impl;

import com.xworkz.Library.dao.LibraryDAO;
import com.xworkz.Library.entity.LibraryEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class LibraryDAOImpl implements LibraryDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("library");
    @Override
    public boolean save(LibraryEntity entity) {

        System.out.println("Running save in LibraryDAOImpl");

        boolean isSaved = false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {

            em = emf.createEntityManager();

            et = em.getTransaction();
            et.begin();

            em.persist(entity);

            et.commit();

            isSaved = true;

            System.out.println(entity);
            System.out.println("Library data saved successfully");

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

        return isSaved;
    }

    @Override
    public boolean savess(List<LibraryEntity> entities) {

        boolean isSaved = false;


        EntityManager em = null;
        EntityTransaction et = null;

        try {

            em = emf.createEntityManager();

            et = em.getTransaction();
            et.begin();

            for (LibraryEntity entity : entities) {
                em.persist(entity);
            }

            et.commit();

            isSaved = true;

            System.out.println(entities);
            System.out.println("All library data saved successfully");

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

        return isSaved;
    }

    @Override
    public LibraryEntity getLibraryEntity(Integer id) {

        LibraryEntity entity = null;


        EntityManager em = null;

        try {

            em = emf.createEntityManager();

            entity = em.find(LibraryEntity.class, id);

        } catch (PersistenceException e) {

            e.printStackTrace();

        } finally {

            if (em != null) {
                em.close();
            }


        }

        return entity;
    }

    @Override
    public List<LibraryEntity> getAllLibraryBooks() {
        List<LibraryEntity>entities= Collections.emptyList();

        EntityManager em = null;

        try {

            em = emf.createEntityManager();
            Query query = em.createNamedQuery("getAllLibraryBooks");

            entities = query.getResultList();
        }catch (PersistenceException e){
            e.printStackTrace();
        }




        return entities;
    }

    @Override
    public LibraryEntity getLibraryEntitys(String authorName) {
        LibraryEntity entitiess= null;

        EntityManager em = null;

        try {

            em = emf.createEntityManager();
            Query query = em.createNamedQuery("getAllLibraryBookss");

            query.setParameter("AuthorName", authorName);

//
            Object ref = query.getSingleResult();

            entitiess = (LibraryEntity) ref;
            System.out.println(""+ref);

        }catch (PersistenceException e){
            e.printStackTrace();
        }




        return entitiess;
    }

    @Override
    public LibraryEntity getLibraryEntityss(Integer id, String bookName) {
        LibraryEntity entitiess= null;
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("library");
            em = emf.createEntityManager();
            Query query = em.createNamedQuery("findLibraryBookByBookName");

            query.setParameter("id",id);
            query.setParameter("bookName",bookName);


            Object ref = query.getSingleResult();
            entitiess=(LibraryEntity) ref;



        }catch (PersistenceException e){
            e.printStackTrace();
        }




        return entitiess;
    }

    @Override
    public List<LibraryEntity> getAllLibraryBooksss(Integer id,String category) {
        List<LibraryEntity>entities= Collections.emptyList();
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("library");
            em = emf.createEntityManager();
            Query query = em.createNamedQuery("findLibraryBookByIdAndcategory");
            query.setParameter("id", id);
            query.setParameter("category", category);

            entities = query.getResultList();
        }catch (PersistenceException e){
            e.printStackTrace();
        }




        return entities;
    }

    @Override
    public List<LibraryEntity> getAllLibraryBookssss(Double price, String authorName) {
        List<LibraryEntity>entities= Collections.emptyList();
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("library");
            em = emf.createEntityManager();
            Query query = em.createNamedQuery("findLibraryBookByauthorName");
            query.setParameter("price", price);
            query.setParameter("authorName", authorName);
            entities = query.getResultList();
        }catch (PersistenceException e){
            e.printStackTrace();
        }




        return entities;
    }

    @Override
    public Boolean updateLibraryBookNamesAndIDAndAuthorName(Integer id, String bookName, String authorName) {
        Boolean isUpdated = false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {

            em = emf.createEntityManager();

            et = em.getTransaction();
            et.begin();

          Query query = em.createQuery("UPDATE LibraryEntity l SET l.bookName = :bookName, l.authorName = :authorName WHERE l.id = :id");
          query.setParameter("id", id);
          query.setParameter("bookName", bookName);
          query.setParameter("authorName", authorName);
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
    public boolean updateLibraryBookNameUsingID(Integer id, String bookName) {
boolean isUpdated=false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {

            em = emf.createEntityManager();

            et = em.getTransaction();
            et.begin();

            Query query = em.createQuery("UPDATE LibraryEntity l SET l.bookName = :bookName WHERE l.id = :id");
            query.setParameter("id", id);
            query.setParameter("bookName", bookName);

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
    public boolean updateLibrarycategoreUsingID(Integer id, String category) {

        boolean isUpdated=false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {

            em = emf.createEntityManager();

            et = em.getTransaction();
            et.begin();

            Query query = em.createQuery("UPDATE LibraryEntity l SET l.category = : category WHERE l.id = :id");
            query.setParameter("id", id);
            query.setParameter("category",category);

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
