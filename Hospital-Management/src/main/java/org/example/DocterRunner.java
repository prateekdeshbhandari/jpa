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

    }
}
