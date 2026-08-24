package org.example.runner.read;

import org.example.entity.SignInEntity;

import javax.persistence.*;

public class ReadSignIn {
    public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager em=null;

        try
        {
            emf= Persistence.createEntityManagerFactory("redbus");
            em=emf.createEntityManager();

            SignInEntity entity=em.find(SignInEntity.class,1);
            System.out.println(entity);
        }
        catch (PersistenceException e)
        {
            e.getMessage();
        }
        finally {
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
