package com.xwork.Bank.Service.impl;

import com.xwork.Bank.Service.DebitAccountService;
import com.xwork.Bank.dao.DebitAccountDAO;
import com.xwork.Bank.dao.impl.DebitAccountDAOImpl;
import com.xwork.Bank.dto.DebitAccountDTO;
import com.xwork.Bank.entity.DebitAccountEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
    @Override
    public List<DebitAccountDTO> readAllDebitAccounts() {

        List<DebitAccountDTO> dtoList = Collections.emptyList();

        DebitAccountDAO dao = new DebitAccountDAOImpl();

        List<DebitAccountEntity> allEntities = dao.getAllDebitAccounts();

        if (allEntities != null) {
            dtoList = allEntities.stream()
                    .map(entity -> new DebitAccountDTO(
                            entity.getId(),
                            entity.getBankName(),
                            entity.getBankName(),
                            entity.getAccountNumber(),
                            entity.getBalance()
                    ))
                    .collect(Collectors.toList());
        }

        return dtoList;
    }

    @Override
    public DebitAccountDTO findReadSaveByName(String name) {

        DebitAccountDTO dto = null;

        if (name != null) {

            DebitAccountDAO dao = new DebitAccountDAOImpl();

            DebitAccountEntity entity = dao.getDebitAccountEntityByName(name);

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

    @Override
    public DebitAccountDTO findReadSaveTwoParameter(int id, String name) {

        DebitAccountDTO dto = null;

        if (name != null) {

            DebitAccountDAO dao = new DebitAccountDAOImpl();

            DebitAccountEntity entity =
                    dao.getDebitAccountEntityByIdAndName(id, name);

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

    @Override
    public List<DebitAccountDTO> findAllDebitAccountTwoParameter(
            int id,
            String bankName) {

        List<DebitAccountDTO> dtoList = Collections.emptyList();

        DebitAccountDAO dao = new DebitAccountDAOImpl();

        List<DebitAccountEntity> allEntities =
                dao.getAllDebitAccountsByIdAndBankName(id, bankName);

        if (bankName != null) {

            dtoList = allEntities.stream()
                    .map(entity -> new DebitAccountDTO(
                            entity.getId(),
                            entity.getAccountHolderName(),
                            entity.getBankName(),
                            entity.getAccountNumber(),
                            entity.getBalance()
                    ))
                    .collect(Collectors.toList());
        }

        return dtoList;
    }

    @Override
    public List<DebitAccountDTO> findAllDebitAccountTwoParameters(
            double balance,
            String name) {

        List<DebitAccountDTO> dtoList = Collections.emptyList();

        DebitAccountDAO dao = new DebitAccountDAOImpl();

        List<DebitAccountEntity> allEntities = dao.getAllDebitAccountsByBalanceAndName(balance, name);

        if (name != null) {

            dtoList = allEntities.stream()
                    .map(entity -> new DebitAccountDTO(
                            entity.getId(),
                            entity.getAccountHolderName(),
                            entity.getBankName(),
                            entity.getAccountNumber(),
                            entity.getBalance()
                    ))
                    .collect(Collectors.toList());
        }

        return dtoList;
    }
}