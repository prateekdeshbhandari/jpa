package com.xworkz.Library.service;

import com.xworkz.Library.dto.LibraryDTO;

import java.util.List;

public interface LibraryService {

    boolean validateAndSave(LibraryDTO dto);

    boolean validateAndSaves(List<LibraryDTO> dto);

    LibraryDTO findReadSaveId(Integer id);
    
List<LibraryDTO>readAllLibraryBooks();
}
