package com.xwork.Bank.Service;

import com.xwork.Bank.dto.DebitAccountDTO;

import java.util.List;

public interface DebitAccountService {
    boolean validateAndSave(DebitAccountDTO dto);

    boolean validateAndSaves(List<DebitAccountDTO> dto);

    DebitAccountDTO findReadSaveId(Integer id);
    List<DebitAccountDTO>readAllDebitAccounts();
    DebitAccountDTO findReadSaveByName(String name);

    DebitAccountDTO findReadSaveTwoParameter(int id, String name);

    List<DebitAccountDTO> findAllDebitAccountTwoParameter(int id, String bankName);

    List<DebitAccountDTO> findAllDebitAccountTwoParameters(double balance, String name);

}
