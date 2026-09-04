package com.xworkz.mobile.service.impl;

import com.xworkz.mobile.dao.MobileStoreDAO;
import com.xworkz.mobile.dao.impl.MobileStoreDAOImpl;
import com.xworkz.mobile.dto.MobileStoreDTO;
import com.xworkz.mobile.entity.MobileStoreEntity;
import com.xworkz.mobile.service.MobileStoreService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MobileStoreServiceImpl implements MobileStoreService {


        @Override
        public boolean validateAndSave(MobileStoreDTO dto) {

            System.out.println("Running validateAndSave in MobileStoreServiceImpl");

            boolean isSaved = false;

            if (dto != null) {

                MobileStoreEntity entity = new MobileStoreEntity();

                entity.setMobileName(dto.getMobileName());
                entity.setBrand(dto.getBrand());
                entity.setPrice(dto.getPrice());
                entity.setColor(dto.getColor());

                MobileStoreDAO dao = new MobileStoreDAOImpl();

                boolean saved = dao.save(entity);

                if (saved) {
                    isSaved = true;
                    System.out.println("Mobile data saved successfully");
                } else {
                    System.out.println("Mobile data is not saved");
                }

            } else {
                System.out.println("Data is null");
            }

            return isSaved;
        }


        @Override
        public boolean validateAndSaves(List<MobileStoreDTO> dto) {

            boolean isSaved = false;

            if (dto != null) {

                List<MobileStoreEntity> entities = new ArrayList<>();

                for (MobileStoreDTO dtos : dto) {

                    MobileStoreEntity entity = new MobileStoreEntity();

                    entity.setMobileName(dtos.getMobileName());
                    entity.setBrand(dtos.getBrand());
                    entity.setPrice(dtos.getPrice());
                    entity.setColor(dtos.getColor());

                    entities.add(entity);
                }

                MobileStoreDAO dao = new MobileStoreDAOImpl();

                boolean saved = dao.savess(entities);

                if (saved) {
                    isSaved = true;
                    System.out.println("Multiple mobile data saved successfully");
                } else {
                    System.out.println("Mobile data is not saved");
                }

            } else {
                System.out.println("Data is null");
            }

            return isSaved;
        }


        @Override
        public MobileStoreDTO findReadSaveId(Integer id) {

            System.out.println("Running findReadSaveId : " + id);

            MobileStoreDTO dto = null;

            if (id != null) {

                MobileStoreDAO dao = new MobileStoreDAOImpl();

                MobileStoreEntity entity =
                        dao.getMobileStoreEntity(id);

                if (entity != null) {

                    dto = new MobileStoreDTO(
                            entity.getId(),
                            entity.getMobileName(),
                            entity.getBrand(),
                            entity.getPrice(),
                            entity.getColor()
                    );
                }
            }

            return dto;
        }
    @Override
    public List<MobileStoreDTO> readAllMobileStores() {

        List<MobileStoreDTO> dtoList = Collections.emptyList();

        MobileStoreDAO dao = new MobileStoreDAOImpl();

        List<MobileStoreEntity> allEntities = dao.getAllMobileStores();

        if (allEntities != null) {
            dtoList = allEntities.stream()
                    .map(entity -> new MobileStoreDTO(
                            entity.getId(),
                            entity.getMobileName(),
                            entity.getBrand(),
                            entity.getPrice(),
                            entity.getColor()
                    ))
                    .collect(Collectors.toList());
        }

        return dtoList;
    }

    @Override
    public MobileStoreDTO findReadSaveByBrand(String brand) {

        MobileStoreDTO dto = null;

        if (brand != null) {

            MobileStoreDAO dao = new MobileStoreDAOImpl();

            MobileStoreEntity entity =
                    dao.getMobileStoreEntityByBrand(brand);

            if (entity != null) {

                dto = new MobileStoreDTO(
                        entity.getId(),
                        entity.getMobileName(),
                        entity.getBrand(),
                        entity.getPrice(),
                        entity.getColor()
                );
            }
        }

        return dto;
    }

    @Override
    public MobileStoreDTO findReadSaveTwoParameter(
            int id,
            String mobileName) {

        MobileStoreDTO dto = null;

        if (mobileName != null) {

            MobileStoreDAO dao = new MobileStoreDAOImpl();

            MobileStoreEntity entity = dao.getMobileStoreEntityByIdAndMobileName(id, mobileName);

            if (entity != null) {

                dto = new MobileStoreDTO(
                        entity.getId(),
                        entity.getMobileName(),
                        entity.getBrand(),
                        entity.getPrice(),
                        entity.getColor()
                );
            }
        }

        return dto;
    }

    @Override
    public List<MobileStoreDTO> findAllMobileStoreTwoParameter(
            int id,
            String color) {

        List<MobileStoreDTO> dtoList =
                Collections.emptyList();

        MobileStoreDAO dao = new MobileStoreDAOImpl();

        List<MobileStoreEntity> allEntities = dao.getAllMobileStoresByIdAndColor(id, color);

        if (color != null) {

            dtoList = allEntities.stream()
                    .map(entity -> new MobileStoreDTO(
                            entity.getId(),
                            entity.getMobileName(),
                            entity.getBrand(),
                            entity.getPrice(),
                            entity.getColor()
                    ))
                    .collect(Collectors.toList());
        }

        return dtoList;
    }

    @Override
    public List<MobileStoreDTO> findAllMobileStoreTwoParameters(
            double price,
            String brand) {

        List<MobileStoreDTO> dtoList =
                Collections.emptyList();

        MobileStoreDAO dao = new MobileStoreDAOImpl();

        List<MobileStoreEntity> allEntities = dao.getAllMobileStoresByPriceAndBrand(price, brand);

        if (brand != null) {

            dtoList = allEntities.stream()
                    .map(entity -> new MobileStoreDTO(
                            entity.getId(),
                            entity.getMobileName(),
                            entity.getBrand(),
                            entity.getPrice(),
                            entity.getColor()
                    ))
                    .collect(Collectors.toList());
        }

        return dtoList;
    }

    @Override
    public String updateMobileNameAndBrand(int id, String mobileName, String brand) {

        String status = null;

        if (id > 0 && mobileName != null && brand != null) {

            MobileStoreDAO dao = new MobileStoreDAOImpl();

            Boolean isUpdate = dao.updateMobileNameAndBrand(id, mobileName, brand);
            if (isUpdate) {
                status = "successful";
            } else {
                status = null;
            }
        }

        return status;
    }

    @Override
    public String updateMobileName(int id, String mobileName) {

        String status = null;

        if (id > 0 && mobileName != null) {

            MobileStoreDAO dao = new MobileStoreDAOImpl();

            Boolean isUpdate = dao.updateMobileNameUsingID(id, mobileName);

            if (isUpdate) {
                status = "successful";
            } else {
                status = null;
            }
        }

        return status;
    }

    @Override
    public String updateMobileColorUsingID(int id, String color) {

        String status = null;

        if (id > 0 && color != null) {

            MobileStoreDAO dao = new MobileStoreDAOImpl();

            Boolean isUpdate = dao.updateMobileColorUsingID(id, color);

            if (isUpdate) {
                status = "successful";
            } else {
                status = null;
            }
        }

        return status;
    }

    @Override
    public List<String> findAllMobileStore() {
        List<String>list=Collections.emptyList();

        MobileStoreDAO dao=new MobileStoreDAOImpl();
        List<String>entity=dao.getMobileName();

        if(entity!=null){
            list=entity;
        }
        return list;
    }

    @Override
    public List<Object> getyAllBrand() {
        List<Object>lists=Collections.emptyList();

        MobileStoreDAO dao=new MobileStoreDAOImpl();
        List<Object>entity=dao.getBrand();

        if(entity!=null){
            lists=entity;
        }
        return lists;
    }
}
