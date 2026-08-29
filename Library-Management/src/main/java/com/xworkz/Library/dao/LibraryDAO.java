package com.xworkz.Library.dao;

import com.xworkz.Library.entity.LibraryEntity;

import java.util.List;

public interface LibraryDAO {

    boolean save(LibraryEntity entity);

    boolean savess(List<LibraryEntity> entities);

    LibraryEntity getLibraryEntity(Integer id);
}

