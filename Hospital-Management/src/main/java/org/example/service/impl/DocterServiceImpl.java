package org.example.service.impl;

import org.example.Entity.DocterEntity;
import org.example.dao.DocterDAO;
import org.example.dao.impl.DocterDAOImpl;
import org.example.dto.DocterDTO;
import org.example.service.DocterService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DocterServiceImpl implements DocterService {
    @Override
    public boolean validateAndSave(DocterDTO dto) {

        System.out.println("Running validateAndSave in DocterServiceImpl");

        boolean isSaved = false;

        if (dto != null) {

            DocterEntity entity = new DocterEntity();

            entity.setName(dto.getName());
            entity.setSpecialization(dto.getSpecialization());
            entity.setHospitalName(dto.getHospitalName());
            entity.setPhoneNumber(dto.getPhoneNumber());

            DocterDAO dao = new DocterDAOImpl();

            boolean saved = dao.save(entity);

            if (saved) {
                isSaved = true;
                System.out.println("Doctor data is saved successfully");
            } else {
                isSaved = false;
                System.out.println("Doctor data is not saved");
            }
        }

        return isSaved;
    }


    @Override
    public boolean validateAndSaves(List<DocterDTO> dto) {

        boolean isSaved = false;

        if (dto != null && !dto.isEmpty()) {

            List<DocterEntity> entities = new ArrayList<>();

            for (DocterDTO dtoss : dto) {

                DocterEntity entity = new DocterEntity();

                entity.setName(dtoss.getName());
                entity.setSpecialization(dtoss.getSpecialization());
                entity.setHospitalName(dtoss.getHospitalName());
                entity.setPhoneNumber(dtoss.getPhoneNumber());

                entities.add(entity);
            }

            DocterDAO dao = new DocterDAOImpl();

            boolean saved = dao.savess(entities);

            if (saved) {
                isSaved = true;
                System.out.println("Doctor data is saved successfully");
            } else {
                System.out.println("Doctor data is not saved");
            }

        } else {

            System.out.println("Doctor data is empty");
        }

        return isSaved;
    }


    @Override
    public DocterDTO findReadSaveId(Integer id) {

        System.out.println("Running findReadSaveId : " + id);

        DocterDTO dto = null;

        if (id != null) {

            DocterDAO dao = new DocterDAOImpl();

            DocterEntity entity = dao.getDocterEntity(id);

            if (entity != null) {

                dto = new DocterDTO(
                        entity.getId(),
                        entity.getName(),
                        entity.getSpecialization(),
                        entity.getHospitalName(),
                        entity.getPhoneNumber()
                );
            }
        }

        return dto;
    }
    @Override
    public List<DocterDTO> readAllDocters() {

        List<DocterDTO> dtoList = Collections.emptyList();

        DocterDAO dao = new DocterDAOImpl();

        List<DocterEntity> allEntities = dao.getAllDocters();

        if (allEntities != null) {
            dtoList = allEntities.stream()
                    .map(entity -> new DocterDTO(
                            entity.getId(),
                            entity.getName(),
                            entity.getSpecialization(),
                            entity.getHospitalName(),
                            entity.getPhoneNumber()
                    ))
                    .collect(Collectors.toList());
        }

        return dtoList;
    }

    @Override
    public DocterDTO findReadSaveByName(String name) {

        DocterDTO dto = null;

        if (name != null) {

            DocterDAO dao = new DocterDAOImpl();

            DocterEntity entity = dao.getDocterEntityByName(name);

            if (entity != null) {

                dto = new DocterDTO(
                        entity.getId(),
                        entity.getName(),
                        entity.getSpecialization(),
                        entity.getHospitalName(),
                        entity.getPhoneNumber()
                );
            }
        }

        return dto;
    }

    @Override
    public DocterDTO findReadSaveTwoParameter(int id, String name) {

        DocterDTO dto = null;

        if (name != null) {

            DocterDAO dao = new DocterDAOImpl();

            DocterEntity entity = dao.getDocterEntityByIdAndName(id, name);

            if (entity != null) {

                dto = new DocterDTO(
                        entity.getId(),
                        entity.getName(),
                        entity.getSpecialization(),
                        entity.getHospitalName(),
                        entity.getPhoneNumber()
                );
            }
        }

        return dto;
    }

    @Override
    public List<DocterDTO> findAllDocterTwoParameter(int id, String specialization) {

        List<DocterDTO> dtoList = Collections.emptyList();

        DocterDAO dao = new DocterDAOImpl();

        List<DocterEntity> allEntities = dao.getAllDoctersByIdAndSpecialization(id, specialization);

        if (specialization != null) {

            dtoList = allEntities.stream()
                    .map(entity -> new DocterDTO(
                            entity.getId(),
                            entity.getName(),
                            entity.getSpecialization(),
                            entity.getHospitalName(),
                            entity.getPhoneNumber()
                    ))
                    .collect(Collectors.toList());
        }

        return dtoList;
    }

    @Override
    public List<DocterDTO> findAllDocterTwoParameters(String hospitalName, String specialization) {

        List<DocterDTO> dtoList = Collections.emptyList();

        DocterDAO dao = new DocterDAOImpl();

        List<DocterEntity> allEntities = dao.getAllDoctersByHospitalNameAndSpecialization(hospitalName, specialization);

        if (hospitalName != null) {

            dtoList = allEntities.stream()
                    .map(entity -> new DocterDTO(
                            entity.getId(),
                            entity.getName(),
                            entity.getSpecialization(),
                            entity.getHospitalName(),
                            entity.getPhoneNumber()
                    ))
                    .collect(Collectors.toList());
        }

        return dtoList;
    }
}