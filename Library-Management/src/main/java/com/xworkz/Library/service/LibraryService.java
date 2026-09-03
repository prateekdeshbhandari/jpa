package com.xworkz.Library.service;

import com.xworkz.Library.dto.LibraryDTO;

import java.util.List;

public interface LibraryService {

    boolean validateAndSave(LibraryDTO dto);

    boolean validateAndSaves(List<LibraryDTO> dto);

    LibraryDTO findReadSaveId(Integer id);


    
List<LibraryDTO>readAllLibraryBooks();

LibraryDTO findReadSaveAuthorName(String authorName);

LibraryDTO findReadSaveTwoParametter(Integer id,String bookName);

List<LibraryDTO>findAllLibrarytwoPrametter(Integer id,String category);

List<LibraryDTO>findAllLibrarytwoPrametters(Double price,String authorName);

 String  updateLibraryBookNameAndAuthorName(Integer id, String bookName,String authorName);
 String updateLibraryBookName(Integer id, String bookName);

 String updateLibrarycategoreUsingID(Integer id, String category);

 List<String>getName();

 List<Object>getAuthorName();
}
