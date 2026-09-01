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

}

