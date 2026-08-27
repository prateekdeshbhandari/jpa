package com.xwork.Bank.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class DebitAccountDTO {

    private Integer id;
    private String accountHolderName;
    private String bankName;
    private String accountNumber;
    private Double balance;

}
