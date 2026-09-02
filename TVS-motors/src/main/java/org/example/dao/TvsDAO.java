package org.example.dao;

import org.example.entity.TvsMotoresEntity;

import java.util.List;

public interface TvsDAO {
    boolean save(TvsMotoresEntity entity);
    boolean savess(List<TvsMotoresEntity> entities );
    TvsMotoresEntity getTvsMotoresEntity(Integer id);
    List<TvsMotoresEntity> getAllTvs();

    TvsMotoresEntity getTvsMotorsEntityByBrand(String brand);

    TvsMotoresEntity getTvsMotorsEntityByIdAndModelName(int id, String modelName);

    List<TvsMotoresEntity> getAllTvsByIdAndCategory(int id, String category);

    List<TvsMotoresEntity> getAllTvsByPriceAndBrand(double price, String brand);


    // Update
    Boolean updateTvsNameAndBrand(Integer id, String name, String brand);
    Boolean updateTvsNameUsingID(Integer id, String name);
    Boolean updateTvsTypeUsingID(Integer id, String type);


}
