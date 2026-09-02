package org.example.service.impl;

import org.example.dao.TvsDAO;
import org.example.dao.impl.TvsDAOIMPL;
import org.example.dto.TvsMotorsDto;
import org.example.entity.TvsMotoresEntity;
import org.example.service.TvsService;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toList;


public class TvsServiceImpl implements TvsService {
    @Override
    public boolean validateAndSave(TvsMotorsDto dto) {
        System.out.println("Running validateAndSave in TvsServiceImpl");
        boolean isSeved = false;

        if (dto != null) {

            TvsMotoresEntity entity = new TvsMotoresEntity();

            entity.setModelName(dto.getModelName());
            entity.setBrand(dto.getBrand());
            entity.setCategory(dto.getCategory());
            entity.setPrice(dto.getPrice());


            TvsDAO dao = new TvsDAOIMPL();
            boolean saveds = dao.save(entity);

            if (saveds) {
                isSeved = true;
                System.out.println("Data is saved successfully");
            } else {
                isSeved = false;
                System.out.println("Data is not saved ");
            }

        }

        return isSeved;

    }

    @Override
    public boolean validateAndSaves(List<TvsMotorsDto> dto) {
        boolean isSeved = false;

        if (dto != null) {
            List<TvsMotoresEntity> entities = new ArrayList<>();
            for (TvsMotorsDto dtoss : dto) {
                TvsMotoresEntity entity = new TvsMotoresEntity();

                entity.setModelName(dtoss.getModelName());
                entity.setBrand(dtoss.getBrand());
                entity.setCategory(dtoss.getCategory());
                entity.setPrice(dtoss.getPrice());
                entities.add(entity);
            }

//            List<TvsMotoresEntity> entities = dto.stream()
//                    .map(dtoo -> new TvsMotoresEntity(
//                            dtoo.getModelName(),
//                            dtoo.getBrand(),
//                            dtoo.getCategory(),
//                            dtoo.getPrice()
//                    ))  .collect(toList());

            TvsDAO dao = new TvsDAOIMPL();
            boolean saveds = dao.savess(entities);

            if (saveds) {
                isSeved = true;
                System.out.println("Data is saved successfully");
            } else {
                isSeved = false;
                System.out.println("Data is not saved ");
            }
            isSeved = true;
        } else {

            System.out.println("Data is empty ");
        }


        return isSeved;

    }

    @Override
    public TvsMotorsDto findReadSaveId(Integer Id) {
        System.out.println("Running findSignUpDtoById : " + Id);

        TvsMotorsDto dto = null;

        if (Id != null) {
            TvsDAO dao = new TvsDAOIMPL();
            TvsMotoresEntity entity = dao.getTvsMotoresEntity(Id);

            if (entity != null) {

                dto = new TvsMotorsDto(entity.getId(),
                        entity.getModelName(),
                        entity.getBrand(),
                        entity.getCategory(),
                        entity.getPrice()
                );
            }
        }

        return dto;
    }

    @Override
    public List<TvsMotorsDto> readAllTvs() {

        List<TvsMotorsDto> dtoList = Collections.emptyList();

        TvsDAO dao = new TvsDAOIMPL();

        List<TvsMotoresEntity> allEntities = dao.getAllTvs();


        if (allEntities != null) {
            dtoList = allEntities.stream()
                    .map(entity -> new TvsMotorsDto(
                            entity.getId(),
                            entity.getModelName(),
                            entity.getBrand(),
                            entity.getCategory(),
                            entity.getPrice()
                    ))
                    .collect(Collectors.toList());
        }

        return dtoList;
    }


    @Override
    public TvsMotorsDto findReadSaveByBrand(String brand) {

        TvsMotorsDto dto = null;

        if (brand != null) {

            TvsDAO dao = new TvsDAOIMPL();

            TvsMotoresEntity entity = dao.getTvsMotorsEntityByBrand(brand);

            if (entity != null) {

                dto = new TvsMotorsDto(
                        entity.getId(),
                        entity.getModelName(),
                        entity.getBrand(),
                        entity.getCategory(),
                        entity.getPrice()
                );
            }
        }

        return dto;
    }

    @Override
    public TvsMotorsDto findReadSaveTwoParameter(int id, String modelName) {

        TvsMotorsDto dto = null;

        if (modelName != null) {

            TvsDAO dao = new TvsDAOIMPL();

            TvsMotoresEntity entity = dao.getTvsMotorsEntityByIdAndModelName(id, modelName);
            if (entity != null) {

                dto = new TvsMotorsDto(
                        entity.getId(),
                        entity.getModelName(),
                        entity.getBrand(),
                        entity.getCategory(),
                        entity.getPrice()
                );
            }
        }

        return dto;
    }

    @Override
    public List<TvsMotorsDto> findAllTvsTwoParameter(int id, String category) {

        List<TvsMotorsDto> dtoList = Collections.emptyList();

        TvsDAO dao = new TvsDAOIMPL();

        List<TvsMotoresEntity> allEntities = dao.getAllTvsByIdAndCategory(id, category);

        if (category != null) {

            dtoList = allEntities.stream()
                    .map(entity -> new TvsMotorsDto(
                            entity.getId(),
                            entity.getModelName(),
                            entity.getBrand(),
                            entity.getCategory(),
                            entity.getPrice()
                    ))
                    .collect(Collectors.toList());
        }

        return dtoList;
    }

    @Override
    public List<TvsMotorsDto> findAllTvsTwoParameters(double price, String brand) {

        List<TvsMotorsDto> dtoList = Collections.emptyList();

        TvsDAO dao = new TvsDAOIMPL();

        List<TvsMotoresEntity> allEntities = dao.getAllTvsByPriceAndBrand(price, brand);

        if (brand != null) {

            dtoList = allEntities.stream()
                    .map(entity -> new TvsMotorsDto(
                            entity.getId(),
                            entity.getModelName(),
                            entity.getBrand(),
                            entity.getCategory(),
                            entity.getPrice()
                    ))
                    .collect(Collectors.toList());
        }

        return dtoList;
    }

    @Override
    public String updateTvsNameAndBrand(Integer id, String name, String brand) {

        String status = null;

        if (id != null && name != null && brand != null) {

            TvsDAO dao = new TvsDAOIMPL();

            Boolean isUpdate =
                    dao.updateTvsNameAndBrand(id, name, brand);

            if (isUpdate) {
                status = "successful";
            } else {
                status = null;
            }
        }

        return status;
    }


    @Override
    public String updateTvsName(Integer id, String name) {

        String status = null;

        if (id != null && name != null) {

            TvsDAO dao = new TvsDAOIMPL();

            Boolean isUpdate =
                    dao.updateTvsNameUsingID(id, name);

            if (isUpdate) {
                status = "successful";
            } else {
                status = null;
            }
        }

        return status;
    }


    @Override
    public String updateTvsTypeUsingID(Integer id, String type) {

        String status = null;

        if (id != null && type != null) {

            TvsDAO dao = new TvsDAOIMPL();

            Boolean isUpdate =
                    dao.updateTvsTypeUsingID(id, type);

            if (isUpdate) {
                status = "successful";
            } else {
                status = null;
            }
        }

        return status;
    }
}


