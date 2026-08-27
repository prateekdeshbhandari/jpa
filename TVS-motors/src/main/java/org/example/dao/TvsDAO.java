package org.example.dao;

import org.example.entity.TvsMotoresEntity;

import java.util.List;

public interface TvsDAO {
    boolean save(TvsMotoresEntity entity);
    boolean savess(List<TvsMotoresEntity> entities );
    TvsMotoresEntity getTvsMotoresEntity(Integer id);
}
