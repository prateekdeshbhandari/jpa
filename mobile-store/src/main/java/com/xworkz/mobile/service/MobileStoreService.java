package com.xworkz.mobile.service;

import com.xworkz.mobile.dto.MobileStoreDTO;

import java.util.List;

public interface MobileStoreService {
    boolean validateAndSave(MobileStoreDTO dto);

    boolean validateAndSaves(List<MobileStoreDTO> dto);

    MobileStoreDTO findReadSaveId(Integer id);
    List<MobileStoreDTO>readAllMobileStores();
    MobileStoreDTO findReadSaveByBrand(String brand);

    MobileStoreDTO findReadSaveTwoParameter(int id, String mobileName);

    List<MobileStoreDTO> findAllMobileStoreTwoParameter(int id, String color);

    List<MobileStoreDTO> findAllMobileStoreTwoParameters(double price, String brand);
}


