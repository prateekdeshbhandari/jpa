package org.example.service;

import org.example.dto.DocterDTO;

import java.util.List;

public interface DocterService {
    boolean validateAndSave(DocterDTO dto);

    boolean validateAndSaves(List<DocterDTO> dto);

    DocterDTO findReadSaveId(Integer id);
    List<DocterDTO>readAllDocters();



    DocterDTO findReadSaveByName(String name);

    DocterDTO findReadSaveTwoParameter(int id, String name);

    List<DocterDTO> findAllDocterTwoParameter(int id, String specialization);

    List<DocterDTO> findAllDocterTwoParameters(String hospitalName, String specialization);

    String updateDocterNameAndSpecialization(int id, String name, String specialization);

    String updateDocterName(int id, String name);

    String updateDocterHospitalUsingID(int id, String hospitalName);

    List<String> getAllDocterNames();

    List<Object> getAllSpecialization();

}

