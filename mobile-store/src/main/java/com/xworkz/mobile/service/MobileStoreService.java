package com.xworkz.mobile.service;

import com.xworkz.mobile.dto.MobileStoreDTO;

import java.util.List;

public interface MobileStoreService {
    boolean validateAndSave(MobileStoreDTO dto);

    boolean validateAndSaves(List<MobileStoreDTO> dto);

    MobileStoreDTO findReadSaveId(Integer id);
    List<MobileStoreDTO>readAllMobileStores();

}
