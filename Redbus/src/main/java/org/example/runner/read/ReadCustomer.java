package org.example.runner.read;

import org.example.entity.CustomerEntity;

import javax.persistence.*;

public class ReadCustomer {
    public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager em=null;

        try
        {
            emf= Persistence.createEntityManagerFactory("redbus");
            em=emf.createEntityManager();

            CustomerEntity entity=em.find(CustomerEntity.class,1);
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