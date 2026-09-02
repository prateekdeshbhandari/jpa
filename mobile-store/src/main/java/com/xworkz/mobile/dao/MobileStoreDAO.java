package com.xworkz.mobile.dao;

import com.xworkz.mobile.entity.MobileStoreEntity;

import java.util.List;

public interface MobileStoreDAO {

    boolean save(MobileStoreEntity entity);

    boolean savess(List<MobileStoreEntity> entities);

    MobileStoreEntity getMobileStoreEntity(Integer id);
    List<MobileStoreEntity>getAllMobileStores();



    MobileStoreEntity getMobileStoreEntityByBrand(String brand);

    MobileStoreEntity getMobileStoreEntityByIdAndMobileName(int id, String mobileNam);

    List<MobileStoreEntity> getAllMobileStoresByIdAndColor(int id, String color);

    List<MobileStoreEntity> getAllMobileStoresByPriceAndBrand(double price, String brand);

    //update
    Boolean updateMobileNameAndBrand(int id, String mobileName, String brand);
    Boolean updateMobileNameUsingID(int id, String mobileName);
    Boolean updateMobileColorUsingID(int id, String color);
}


