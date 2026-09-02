package com.xwork.Bank.dao;

import com.xwork.Bank.entity.DebitAccountEntity;

import java.util.List;

public interface DebitAccountDAO {
    boolean save(DebitAccountEntity entity);

    boolean savess(List<DebitAccountEntity> entities);

    DebitAccountEntity getDebitAccountEntity(Integer id);
    List<DebitAccountEntity>getAllDebitAccounts();

    DebitAccountEntity getDebitAccountEntityByName(String name);

    DebitAccountEntity getDebitAccountEntityByIdAndName(int id, String name);

    List<DebitAccountEntity> getAllDebitAccountsByIdAndBankName(int id, String bankName);

    List<DebitAccountEntity> getAllDebitAccountsByBalanceAndName(double balance, String name);

    //update methods
    Boolean updateDebitAccountNameAndBank(int id, String name, String bankName);
    Boolean updateDebitAccountNameUsingID(int id, String name);
    Boolean updateDebitAccountBankUsingID(int id, String bankName);


}
