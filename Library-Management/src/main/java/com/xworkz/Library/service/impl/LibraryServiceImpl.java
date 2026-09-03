package com.xworkz.Library.service.impl;

import com.xworkz.Library.dao.LibraryDAO;
import com.xworkz.Library.dao.impl.LibraryDAOImpl;
import com.xworkz.Library.dto.LibraryDTO;
import com.xworkz.Library.entity.LibraryEntity;
import com.xworkz.Library.service.LibraryService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryServiceImpl implements LibraryService {
    @Override
    public boolean validateAndSave(LibraryDTO dto) {

        System.out.println("Running validateAndSave in LibraryServiceImpl");

        boolean isSaved = false;

        if (dto != null) {

            LibraryEntity entity = new LibraryEntity();

            entity.setBookName(dto.getBookName());
            entity.setAuthorName(dto.getAuthorName());
            entity.setCategory(dto.getCategory());
            entity.setPrice(dto.getPrice());

            LibraryDAO dao = new LibraryDAOImpl();

            boolean saved = dao.save(entity);

            if (saved) {
                isSaved = true;
                System.out.println("Library data saved successfully");
            } else {
                System.out.println("Library data is not saved");
            }
        }

        return isSaved;
    }

    @Override
    public boolean validateAndSaves(List<LibraryDTO> dto) {

        boolean isSaved = false;

        if (dto != null) {

            List<LibraryEntity> entities = new ArrayList<>();

            for (LibraryDTO dtos : dto) {

                LibraryEntity entity = new LibraryEntity();

                entity.setBookName(dtos.getBookName());
                entity.setAuthorName(dtos.getAuthorName());
                entity.setCategory(dtos.getCategory());
                entity.setPrice(dtos.getPrice());

                entities.add(entity);
            }

            LibraryDAO dao = new LibraryDAOImpl();

            boolean saved = dao.savess(entities);

            if (saved) {
                isSaved = true;
                System.out.println("All library data saved successfully");
            } else {
                System.out.println("Library data is not saved");
            }

        } else {
            System.out.println("Data is empty");
        }

        return isSaved;
    }

    @Override
    public LibraryDTO findReadSaveId(Integer id) {

        System.out.println("Running findReadSaveId : " + id);

        LibraryDTO dto = null;

        if (id != null) {

            LibraryDAO dao = new LibraryDAOImpl();

            LibraryEntity entity = dao.getLibraryEntity(id);

            if (entity != null) {

                dto = new LibraryDTO(
                        entity.getId(),
                        entity.getBookName(),
                        entity.getAuthorName(),
                        entity.getCategory(),
                        entity.getPrice());
            }
        }

        return dto;
    }


    @Override
    public List<LibraryDTO> readAllLibraryBooks() {

        List<LibraryDTO> dtoList = Collections.emptyList();

        LibraryDAO dao = new LibraryDAOImpl();

        List<LibraryEntity> allEntities = dao.getAllLibraryBooks();

        if (allEntities != null) {
            dtoList = allEntities.stream()
                    .map(entity -> new LibraryDTO(entity.getId(),
                            entity.getBookName(),
                            entity.getAuthorName(),
                            entity.getCategory(),
                            entity.getPrice()
                    )).collect(Collectors.toList());
        }

        return dtoList;
    }

    @Override
    public LibraryDTO findReadSaveAuthorName(String authorName) {
        LibraryDTO dtos = null;

        if (authorName != null) {

            LibraryDAO dao = new LibraryDAOImpl();

            LibraryEntity entity = dao.getLibraryEntitys(authorName);

            if (entity != null) {

                dtos = new LibraryDTO(
                        entity.getId(),
                        entity.getBookName(),
                        entity.getAuthorName(),
                        entity.getCategory(),
                        entity.getPrice());
            }
        }

        return dtos;
    }

    @Override
    public LibraryDTO findReadSaveTwoParametter(Integer id, String bookName) {
        LibraryDTO dtos = null;

        if (bookName!=null) {

            LibraryDAO dao = new LibraryDAOImpl();

            LibraryEntity entity = dao.getLibraryEntityss(id,bookName);

            if (entity != null) {

                dtos = new LibraryDTO(
                        entity.getId(),
                        entity.getBookName(),
                        entity.getAuthorName(),
                        entity.getCategory(),
                        entity.getPrice());
            }
        }

        return dtos;
    }

    @Override
    public List<LibraryDTO> findAllLibrarytwoPrametter(Integer id, String category) {
        List<LibraryDTO> dtoList = Collections.emptyList();

        LibraryDAO dao = new LibraryDAOImpl();

        List<LibraryEntity> allEntities = dao.getAllLibraryBooksss(id,category);

        if (category != null) {
            dtoList = allEntities.stream()
                    .map(entity -> new LibraryDTO(entity.getId(),
                            entity.getBookName(),
                            entity.getAuthorName(),
                            entity.getCategory(),
                            entity.getPrice()
                    )).collect(Collectors.toList());
        }

        return dtoList;
    }

    @Override
    public List<LibraryDTO> findAllLibrarytwoPrametters(Double price, String authorName) {
        List<LibraryDTO> dtoList = Collections.emptyList();

        LibraryDAO dao = new LibraryDAOImpl();

        List<LibraryEntity> allEntities = dao.getAllLibraryBookssss(price,authorName);

        if (authorName != null) {
            dtoList = allEntities.stream()
                    .map(entity -> new LibraryDTO(entity.getId(),
                            entity.getBookName(),
                            entity.getAuthorName(),
                            entity.getCategory(),
                            entity.getPrice()
                    )).collect(Collectors.toList());
        }

        return dtoList;
    }

    @Override
    public String updateLibraryBookNameAndAuthorName(Integer id, String bookName,String authorName) {
        String status=null;

        if(id!=null&&bookName!=null&&authorName!=null){

            LibraryDAO dao=new LibraryDAOImpl();
            Boolean isUpdate=dao.updateLibraryBookNamesAndIDAndAuthorName(id,bookName,authorName);
            if(isUpdate){
                status="sucssefull";

            }else {
                status=null;
            }
        }

        return status;
    }

    @Override
    public String updateLibraryBookName(Integer id, String bookName) {

        String Status=null;

        if(id!=null&&bookName!=null){

            LibraryDAO dao=new LibraryDAOImpl();
            Boolean isUpdate=dao.updateLibraryBookNameUsingID(id,bookName);
            if(isUpdate){
                Status="sucssefull";

            }else {
                Status=null;
            }
        }

        return Status;
    }

    @Override
    public String updateLibrarycategoreUsingID(Integer id, String category) {
        String status=null;
        if(id!=null&&category!=null) {
            LibraryDAO dao = new LibraryDAOImpl();
            Boolean isUpdate = dao.updateLibrarycategoreUsingID(id, category);
            if (isUpdate) {
                status = "sucssefull";

            } else {
                status = null;
            }
        }

        return status;
    }

    @Override
    public List<String> getName() {
        List<String>list=Collections.emptyList();

        LibraryDAO dao = new LibraryDAOImpl();

       List<String>lists= dao.getBookName();
       if(lists!=null){
           list=lists;
       }


        return list;
    }

    @Override
    public List<Object> getAuthorName() {
        System.out.println("Running getAuthorName in LibraryServiceImpl");

        List<Object>entity=Collections.emptyList();
        LibraryDAO dao=new LibraryDAOImpl();

        List<Object>conte=dao.getAuthorNamess();

        if(conte!=null){
            entity=conte;
        }
        return entity;
    }

}
