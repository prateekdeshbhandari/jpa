package org.example.runner.update;


import org.example.entity.SingUpEntity;

import javax.persistence.*;

public class UpdateSignup {

    public static void main(String[] args) {

        EntityManagerFactory emf=null;
        EntityManager em=null;
        EntityTransaction et=null;

        try
        {
            emf= Persistence.createEntityManagerFactory("redbus");
            em=emf.createEntityManager();
            et=em.getTransaction();
            et.begin();

            SingUpEntity entity=em.find(SingUpEntity.class,1);
            System.out.println("before update:"+entity);

            if(entity!=null)
            {
                entity.setEmail("sai@gmail.com");
                entity.setPassword("sai123");

                SingUpEntity updatedEntity=em.merge(entity);
                System.out.println("after update:"+updatedEntity);
                et.commit();
            }
        }
        catch (PersistenceException e)
        {
            if(et!=null)
            {
                et.rollback();
            }
            e.printStackTrace();
        }
        finally
        {
            if(emf!=null)
            {
                emf.close();
            }
            if(em!=null)
            {
                em.close();
            }
        }
    }
}