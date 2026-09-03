package com.xworkz.Library.dao;

import com.xworkz.Library.entity.LibraryEntity;

import java.util.List;

public interface LibraryDAO {

    boolean save(LibraryEntity entity);

    boolean savess(List<LibraryEntity> entities);

    LibraryEntity getLibraryEntity(Integer id);



    List<LibraryEntity> getAllLibraryBooks();

    LibraryEntity getLibraryEntitys(String authorName);
    LibraryEntity getLibraryEntityss(Integer id,String bookName);

    List<LibraryEntity> getAllLibraryBooksss(Integer id,String category);

    List<LibraryEntity>getAllLibraryBookssss(Double price,String authorName);

    Boolean updateLibraryBookNamesAndIDAndAuthorName(Integer id, String bookName,String authorName);
    boolean updateLibraryBookNameUsingID(Integer id,String bookName);
    boolean updateLibrarycategoreUsingID(Integer id,String category);


    List<String>getBookName();


    List<Object>getAuthorNamess();
}

