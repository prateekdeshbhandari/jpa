package com.xworkz.mobile.dao;

import com.xworkz.mobile.entity.MobileStoreEntity;

import java.util.List;

public interface MobileStoreDAO {

    boolean save(MobileStoreEntity entity);

    boolean savess(List<MobileStoreEntity> entities);

    MobileStoreEntity getMobileStoreEntity(Integer id);

}
