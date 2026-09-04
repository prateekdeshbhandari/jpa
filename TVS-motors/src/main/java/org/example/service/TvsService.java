package org.example.service;

import org.example.dto.TvsMotorsDto;

import java.util.List;

public interface TvsService {
    boolean validateAndSave(TvsMotorsDto dto);
    boolean validateAndSaves(List<TvsMotorsDto> dto);
    TvsMotorsDto findReadSaveId(Integer Id);
    List<TvsMotorsDto> readAllTvs();



    TvsMotorsDto findReadSaveByBrand(String brand);
    TvsMotorsDto findReadSaveTwoParameter(int id, String modelName);
    List<TvsMotorsDto> findAllTvsTwoParameter(int id, String type);
    List<TvsMotorsDto> findAllTvsTwoParameters(double price, String brand);

    // Update

    String updateTvsNameAndBrand(Integer id, String name, String brand);
    String updateTvsName(Integer id, String name);
    String updateTvsTypeUsingID(Integer id, String type);


    List<String>getAllModelName();
    List<Object>getAllCategory();



}



