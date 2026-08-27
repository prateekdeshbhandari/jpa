package org.example.service;

import org.example.dto.DocterDTO;

import java.util.List;

public interface DocterService {
    boolean validateAndSave(DocterDTO dto);

    boolean validateAndSaves(List<DocterDTO> dto);

    DocterDTO findReadSaveId(Integer id);
}

