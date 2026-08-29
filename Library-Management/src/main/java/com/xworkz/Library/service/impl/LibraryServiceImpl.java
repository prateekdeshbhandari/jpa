package com.xworkz.Library.service.impl;

import com.xworkz.Library.dao.LibraryDAO;
import com.xworkz.Library.dao.impl.LibraryDAOImpl;
import com.xworkz.Library.dto.LibraryDTO;
import com.xworkz.Library.entity.LibraryEntity;
import com.xworkz.Library.service.LibraryService;

import java.util.ArrayList;
import java.util.List;

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

}
