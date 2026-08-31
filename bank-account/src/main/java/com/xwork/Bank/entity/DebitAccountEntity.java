package com.xwork.Bank.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "debit_account")
@ToString
@AllArgsConstructor
@NoArgsConstructor
// Select
@NamedQuery(name = "getAllDebitAccounts", query = "select d from DebitAccountEntity d")
@NamedQuery(name = "findDebitAccountByName", query = "select d from DebitAccountEntity d where d.name = :name")
@NamedQuery(name = "findDebitAccountByBankName", query = "select d from DebitAccountEntity d where d.bankName = :bankName")
@NamedQuery(name = "findDebitAccountByAccountNumber", query = "select d from DebitAccountEntity d where d.accountNumber = :accountNumber")
@NamedQuery(name = "findDebitAccountByBalance", query = "select d from DebitAccountEntity d where d.balance = :balance")

// Update
@NamedQuery(name = "updateDebitAccountName", query = "update DebitAccountEntity d set d.name = :name where d.id = :id")
@NamedQuery(name = "updateDebitAccountBalance", query = "update DebitAccountEntity d set d.balance = :balance where d.id = :id")

// Delete
@NamedQuery(name = "deleteDebitAccount", query = "delete from DebitAccountEntity d where d.id = :id")
public class DebitAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "account_holder_name")
    private String accountHolderName;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "balance")
    private Double balance;

}
