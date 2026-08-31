package com.xwork.Bank.dao;

import com.xwork.Bank.entity.DebitAccountEntity;

import java.util.List;

public interface DebitAccountDAO {
    boolean save(DebitAccountEntity entity);

    boolean savess(List<DebitAccountEntity> entities);

    DebitAccountEntity getDebitAccountEntity(Integer id);
    List<DebitAccountEntity>getAllDebitAccounts();

}
