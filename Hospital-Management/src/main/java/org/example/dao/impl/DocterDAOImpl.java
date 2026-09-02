package org.example.dao.impl;

import org.example.Entity.DocterEntity;
import org.example.dao.DocterDAO;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class DocterDAOImpl implements DocterDAO {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("library");
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


    @Override
    public List<DocterEntity> getAllDocters() {

        List<DocterEntity> entities = Collections.emptyList();

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("docter");
            em = emf.createEntityManager();

            Query query = em.createNamedQuery("getAllDocters");

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
    public DocterEntity getDocterEntityByName(String name) {

        DocterEntity entity = null;
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("docter");
            em = emf.createEntityManager();

            Query query = em.createNamedQuery("findDocterByName");

            query.setParameter("name", name);

            Object ref = query.getSingleResult();

            entity = (DocterEntity) ref;

            System.out.println("" + ref);

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public DocterEntity getDocterEntityByIdAndName(Integer id, String name) {

        DocterEntity entity = null;
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("docter");
            em = emf.createEntityManager();

            Query query = em.createNamedQuery("findDocterByIdAndName");

            query.setParameter("id", id);
            query.setParameter("name", name);

            Object ref = query.getSingleResult();

            entity = (DocterEntity) ref;

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public List<DocterEntity> getAllDoctersByIdAndSpecialization(Integer id, String specialization) {

        List<DocterEntity> entities = Collections.emptyList();

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("docter");
            em = emf.createEntityManager();

            Query query = em.createNamedQuery("findDocterByIdAndSpecialization");

            query.setParameter("id", id);
            query.setParameter("specialization", specialization);

            entities = query.getResultList();

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public List<DocterEntity> getAllDoctersByHospitalNameAndSpecialization(String hospitalName, String specialization) {

        List<DocterEntity> entities = Collections.emptyList();

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("docter");
            em = emf.createEntityManager();

            Query query = em.createNamedQuery("findDocterByHospitalNameAndSpecialization");

            query.setParameter("hospitalName", hospitalName);

            query.setParameter("specialization", specialization);

            entities = query.getResultList();

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public boolean updateDocterNameAndSpecialization(Integer id, String name, String specialization) {

        boolean isUpdated = false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {

            em = emf.createEntityManager();

            et = em.getTransaction();
            et.begin();

            Query query = em.createQuery("UPDATE DocterEntity d " + "SET d.name = :name, d.specialization = :specialization " + "WHERE d.id = :id");

            query.setParameter("id", id);
            query.setParameter("name", name);
            query.setParameter("specialization", specialization);

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
    public boolean updateDocterNameUsingID(Integer id, String name) {

        boolean isUpdated = false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {

            em = emf.createEntityManager();

            et = em.getTransaction();
            et.begin();

            Query query = em.createQuery("UPDATE DocterEntity d " + "SET d.name = :name " + "WHERE d.id = :id");

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
    public boolean updateDocterHospitalUsingID(Integer id, String hospitalName) {

        boolean isUpdated = false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {

            em = emf.createEntityManager();

            et = em.getTransaction();
            et.begin();

            Query query = em.createQuery("UPDATE DocterEntity d " + "SET d.hospitalName = :hospitalName " + "WHERE d.id = :id");

            query.setParameter("id", id);
            query.setParameter("hospitalName", hospitalName);

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
