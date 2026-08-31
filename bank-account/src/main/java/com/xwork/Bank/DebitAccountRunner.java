package com.xwork.Bank;

import com.xwork.Bank.Service.DebitAccountService;
import com.xwork.Bank.Service.impl.DebitAccountServiceImpl;
import com.xwork.Bank.dto.DebitAccountDTO;

import java.util.ArrayList;
import java.util.List;

public class DebitAccountRunner {
    public static void main(String[] args) {


        DebitAccountDTO dto = new DebitAccountDTO(1, "Prateek", "HDFC Bank", "1234567890", 50000.00);
        DebitAccountService service = new DebitAccountServiceImpl();
        service.validateAndSave(dto);
        System.out.println("Data: " + dto);

        List<DebitAccountDTO> debitAccountDTOs = new ArrayList<>();

        debitAccountDTOs.add(new DebitAccountDTO(1, "Prateek", "HDFC Bank", "1234567890", 50000.00));
        debitAccountDTOs.add(new DebitAccountDTO(2, "Rahul", "SBI Bank", "2345678901", 75000.00));
        debitAccountDTOs.add(new DebitAccountDTO(3, "Ramesh", "ICICI Bank", "3456789012", 60000.00));
        debitAccountDTOs.add(new DebitAccountDTO(4, "Anil", "Axis Bank", "4567890123", 45000.00));
        debitAccountDTOs.add(new DebitAccountDTO(5, "Kiran", "Canara Bank", "5678901234", 35000.00));

        service.validateAndSaves(debitAccountDTOs);
        DebitAccountDTO readById = service.findReadSaveId(1);
        System.out.println("Read by ID: " + readById);
        List<DebitAccountDTO> allAccounts = service.readAllDebitAccounts();

        System.out.println("All Debit Accounts:");

        allAccounts.forEach(a-> System.out.println(a));
    }
}

