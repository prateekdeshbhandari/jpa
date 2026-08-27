package org.example.service;

import org.example.dto.TvsMotorsDto;

import java.util.List;

public interface TvsService {
    boolean validateAndSave(TvsMotorsDto dto);
    boolean validateAndSaves(List<TvsMotorsDto> dto);
    TvsMotorsDto findReadSaveId(Integer Id);

}
