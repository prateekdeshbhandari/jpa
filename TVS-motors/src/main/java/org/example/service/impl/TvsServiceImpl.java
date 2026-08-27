package org.example.service.impl;

import org.example.dao.TvsDAO;
import org.example.dao.impl.TvsDAOIMPL;
import org.example.dto.TvsMotorsDto;
import org.example.entity.TvsMotoresEntity;
import org.example.service.TvsService;
import java.sql.SQLOutput;
import java.util.ArrayList;
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

        if(dto!=null) {
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
            }

        else{

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

                dto = new TvsMotorsDto(dto.getId(),
                        entity.getModelName(),
                        entity.getBrand(),
                        entity.getCategory(),
                        entity.getPrice()
                );
            }
        }

        return dto;
    }
    }


