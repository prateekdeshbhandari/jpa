package org.example.dao;

import org.example.Entity.DocterEntity;

import java.util.List;

public interface DocterDAO {

    boolean save(DocterEntity entity);

    boolean savess(List<DocterEntity> entities);

    DocterEntity getDocterEntity(Integer id);
    List<DocterEntity>getAllDocters();
}
