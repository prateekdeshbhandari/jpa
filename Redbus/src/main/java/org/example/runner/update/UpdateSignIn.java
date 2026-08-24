package org.example.runner.update;

import org.example.entity.SignInEntity;

import javax.persistence.*;

public class UpdateSignIn {
    public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager em=null;
        EntityTransaction et=null;

        try {
            emf = Persistence.createEntityManagerFactory("redbus");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            SignInEntity entity=em.find(SignInEntity.class,1);
            System.out.println("before update:"+entity);

            if(entity!=null)
            {
                entity.setEmail("ram@gmail.com");
                entity.setPassword("ram123");

                SignInEntity updatedEntity=em.merge(entity);
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