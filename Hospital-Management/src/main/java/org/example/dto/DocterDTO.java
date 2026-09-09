package org.example.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class DocterDTO {

    private int id;
    @NotNull(message=":Name is required")
    @Size(min = 3, max = 50, message = ":Name must be between 3 and 50 characters")
    private String name;
    @NotNull(message=":Specialization is required")
    @Size(min = 3, max = 50, message = ":Speilization")
    private String specialization;
    @NotNull(message=":Hospital name is required")
    @Size(min = 3, max = 50, message = ":Hospital name must be between 3 and 50 characters")
    private String hospitalName;
    @NotNull(message=":Phone number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = ":Phone number must be 10 digits")
    private String phoneNumber;

}