package com.xworkz.Library;

import com.xworkz.Library.dto.LibraryDTO;
import com.xworkz.Library.service.LibraryService;
import com.xworkz.Library.service.impl.LibraryServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class LibraryRunner {

    public static void main(String[] args) {

        LibraryDTO dto = new LibraryDTO(1, "Java Complete Reference", "Herbert Schildt", "Programming", 850.00);

        LibraryService service = new LibraryServiceImpl();

        service.validateAndSave(dto);

        System.out.println("Data: " + dto);


        List<LibraryDTO> libraryDTOs = new ArrayList<>();

        libraryDTOs.add(new LibraryDTO(1, "Java Complete Reference", "Herbert Schildt", "Programming", 850.00));
        libraryDTOs.add(new LibraryDTO(2, "Python Basics", "John Smith", "Programming", 700.00));
        libraryDTOs.add(new LibraryDTO(3, "Data Structures", "Robert Lafore", "Programming", 900.00));
        libraryDTOs.add(new LibraryDTO(4, "Clean Code", "Robert Martin", "Software", 1200.00));
        libraryDTOs.add(new LibraryDTO(5, "Database System", "Abraham Silberschatz", "Database", 1000.00));

        service.validateAndSaves(libraryDTOs);


//        LibraryDTO readById = service.findReadSaveId(1);
//
//        System.out.println("Read by ID: " + readById);

        List<LibraryDTO> allLibraryBooks = service.readAllLibraryBooks();
        allLibraryBooks.forEach(a-> System.out.println(a));




        LibraryDTO libraryDTO = service.findReadSaveAuthorName("Herbert Schildt");

        System.out.println("Library DTO: " + libraryDTO);

        LibraryDTO librardto=service.findReadSaveTwoParametter(1,"Java Complete Reference");
        System.out.println("library dto"+librardto);

      List<LibraryDTO>libraryDTOS=service.findAllLibrarytwoPrametter(1,"Programming");
      libraryDTOS.forEach(a-> System.out.println(a));

//      List<LibraryDTO>libraryDTOss=service.findAllLibrarytwoPrametters( 700.00,"John Smith");
//      libraryDTOss.forEach(a-> System.out.println(a));


      String status = service.updateLibraryBookNameAndAuthorName(1,"DSA", "Prateek");
      System.out.println("Updated library DTO: " + status);

      String status1 = service.updateLibraryBookName(2,"Python Basics");
      System.out.println("Updated library DTO: " + status1);

      String status2 = service.updateLibrarycategoreUsingID(4,"IT");
      System.out.println("Updated library DTO: " + status2);
        System.out.println("=================================");
//
//        System.out.println(allLibraryBooks);
    }

}
