package com.xwork.Bank.Service.impl;

import com.xwork.Bank.Service.DebitAccountService;
import com.xwork.Bank.dao.DebitAccountDAO;
import com.xwork.Bank.dao.impl.DebitAccountDAOImpl;
import com.xwork.Bank.dto.DebitAccountDTO;
import com.xwork.Bank.entity.DebitAccountEntity;

import java.util.ArrayList;
import java.util.List;

public class DebitAccountServiceImpl implements DebitAccountService {
    @Override
    public boolean validateAndSave(DebitAccountDTO dto) {

        System.out.println("Running validateAndSave in DebitAccountServiceImpl");

        boolean isSaved = false;

        if (dto != null) {

            DebitAccountEntity entity = new DebitAccountEntity();

            entity.setAccountHolderName(dto.getAccountHolderName());
            entity.setBankName(dto.getBankName());
            entity.setAccountNumber(dto.getAccountNumber());
            entity.setBalance(dto.getBalance());

            DebitAccountDAO dao = new DebitAccountDAOImpl();

            boolean saved = dao.save(entity);

            if (saved) {
                isSaved = true;
                System.out.println("Debit account data saved successfully");
            } else {
                System.out.println("Debit account data is not saved");
            }
        } else {
            System.out.println("Data is null");
        }

        return isSaved;
    }


    @Override
    public boolean validateAndSaves(List<DebitAccountDTO> dto) {

        boolean isSaved = false;

        if (dto != null) {

            List<DebitAccountEntity> entities = new ArrayList<>();

            for (DebitAccountDTO dtos : dto) {

                DebitAccountEntity entity = new DebitAccountEntity();

                entity.setAccountHolderName(dtos.getAccountHolderName());
                entity.setBankName(dtos.getBankName());
                entity.setAccountNumber(dtos.getAccountNumber());
                entity.setBalance(dtos.getBalance());

                entities.add(entity);
            }

            DebitAccountDAO dao = new DebitAccountDAOImpl();

            boolean saved = dao.savess(entities);

            if (saved) {
                isSaved = true;
                System.out.println("Multiple debit account data saved successfully");
            } else {
                System.out.println("Debit account data is not saved");
            }

        } else {
            System.out.println("Data is null");
        }

        return isSaved;
    }


    @Override
    public DebitAccountDTO findReadSaveId(Integer id) {

        System.out.println("Running findReadSaveId : " + id);

        DebitAccountDTO dto = null;

        if (id != null) {

            DebitAccountDAO dao = new DebitAccountDAOImpl();

            DebitAccountEntity entity =
                    dao.getDebitAccountEntity(id);

            if (entity != null) {

                dto = new DebitAccountDTO(
                        entity.getId(),
                        entity.getAccountHolderName(),
                        entity.getBankName(),
                        entity.getAccountNumber(),
                        entity.getBalance()
                );
            }
        }

        return dto;
    }
}