package org.example.runner.read;




import org.example.entity.BookingEntity;

import javax.persistence.*;
import lombok.ToString;

@ToString
public class ReadBooking {
    public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager em=null;

        try
        {
            emf= Persistence.createEntityManagerFactory("redbus");
            em=emf.createEntityManager();

            BookingEntity entity=em.find(BookingEntity.class,1);
            System.out.println(entity);
        }
        catch (PersistenceException e)
        {
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