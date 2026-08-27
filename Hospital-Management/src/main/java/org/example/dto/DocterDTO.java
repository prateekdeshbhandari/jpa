package org.example.dto;

import lombok.*;

import javax.persistence.Entity;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DocterDTO {

    private int id;
    private String name;
    private String specialization;
    private String hospitalName;
    private String phoneNumber;

}