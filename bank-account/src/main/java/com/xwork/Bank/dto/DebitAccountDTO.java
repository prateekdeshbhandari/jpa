package com.xwork.Bank.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class DebitAccountDTO {

    private Integer id;
    @NotNull(message = "Account holder name cannot be null")
    @Size(min = 3, max = 50, message = "Account holder name must be between 3 and 50 characters")
    private String accountHolderName;
    @NotNull(message = "Bank name cannot be null")
    @Size(min = 3, max = 50, message = "Bank name must be between 3 and 50 characters")
    private String bankName;
    @NotNull(message = "Account number cannot be null")
    @Size(min = 10, max = 18, message = "Account number must be between 10 and 18 characters")
    private String accountNumber;
    @NotNull(message = "Balance cannot be null")
    @Min(value = 0, message = "Balance cannot be negative")
    private Double balance;

}
