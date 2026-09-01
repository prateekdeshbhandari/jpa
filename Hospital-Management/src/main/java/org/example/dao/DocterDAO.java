package org.example.dao;

import org.example.Entity.DocterEntity;

import java.util.List;

public interface DocterDAO {

    boolean save(DocterEntity entity);

    boolean savess(List<DocterEntity> entities);

    DocterEntity getDocterEntity(Integer id);
    List<DocterEntity>getAllDocters();

    DocterEntity getDocterEntityByName(String name);

    DocterEntity getDocterEntityByIdAndName(Integer id, String name);

    List<DocterEntity> getAllDoctersByIdAndSpecialization(Integer id, String specialization);

    List<DocterEntity> getAllDoctersByHospitalNameAndSpecialization(String hospitalName, String specialization);
}

