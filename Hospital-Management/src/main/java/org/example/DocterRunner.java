package org.example;

import org.example.dto.DocterDTO;
import org.example.service.DocterService;
import org.example.service.impl.DocterServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class DocterRunner {

    public static void main(String[] args) {
        DocterDTO dto = new DocterDTO(1, "Rahul Sharma", "Cardiologist", "Apollo Hospital", "9876543210");

        DocterService service = new DocterServiceImpl();
        service.validateAndSave(dto);
        System.out.println("Data: " + dto);

        List<DocterDTO> docterDTOs = new ArrayList<>();

        docterDTOs.add(new DocterDTO(1, "Rahul Sharma", "Cardiologist", "Apollo Hospital", "9876543210"));
        docterDTOs.add(new DocterDTO(2, "Priya Reddy", "Dermatologist", "Fortis Hospital", "9876543211"));
        docterDTOs.add(new DocterDTO(3, "Amit Kumar", "Neurologist", "Manipal Hospital", "9876543212"));
        docterDTOs.add(new DocterDTO(4, "Sneha Patil", "Pediatrician", "Narayana Hospital", "9876543213"));
        docterDTOs.add(new DocterDTO(5, "Vikram Singh", "Orthopedic", "Sakra Hospital", "9876543214"));

        DocterService services = new DocterServiceImpl();

        services.validateAndSaves(docterDTOs);

        DocterDTO readById = services.findReadSaveId(1);
        System.out.println("Read by ID: " + readById);
        List<DocterDTO> allDoctors = services.readAllDocters();

        System.out.println("All Doctors:");
//
//        allDoctors.forEach(a-> System.out.println(a));
//
//        DocterDTO doctorByName = services.findReadSaveByName("Rahul Sharma");
//        System.out.println("Doctor By Name: " + doctorByName);
//
//
//        DocterDTO doctorByIdAndName = services.findReadSaveTwoParameter(1, "Rahul Sharma");
//        System.out.println("Doctor By ID and Name: " + doctorByIdAndName);
//
//
//        List<DocterDTO> doctorsByIdAndSpecialization = services.findAllDocterTwoParameter(1, "Cardiologist");
//        doctorsByIdAndSpecialization.forEach(a -> System.out.println(a));


        List<DocterDTO> doctorsByHospitalAndSpecialization = services.findAllDocterTwoParameters("Apollo Hospital", "Cardiologist");
        doctorsByHospitalAndSpecialization.forEach(a -> System.out.println(a));


        String status = services.updateDocterNameAndSpecialization(1, "Prateek Deshbhandari", "Neurologist");
        System.out.println("Updated Doctor: " + status);

        String status1 = services.updateDocterName(2, "Arun Kumar");
        System.out.println("Updated Doctor Name: " + status1);

        String status2 = services.updateDocterHospitalUsingID(4, "Apollo Hospital");
        System.out.println("Updated Doctor Hospital: " + status2);


        List<String>ref=services.getAllDocterNames();
        System.out.println("All Docter Names: " + ref);

        List<Object>refs=services.getAllSpecialization();
        System.out.println("All Docter Names and Specialization: " + refs);
    }

}


