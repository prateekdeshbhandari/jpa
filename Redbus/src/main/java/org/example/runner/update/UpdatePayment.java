package org.example.runner.update;


import org.example.entity.PaymentEntity;

import javax.persistence.*;

public class UpdatePayment {
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

            PaymentEntity entity=em.find(PaymentEntity.class,1);
            System.out.println("before update:"+entity);

            if(entity!=null)
            {
                entity.setPaymentMethod("cash");
                entity.setAmount(250.00);

                PaymentEntity updatedEntity=em.merge(entity);
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