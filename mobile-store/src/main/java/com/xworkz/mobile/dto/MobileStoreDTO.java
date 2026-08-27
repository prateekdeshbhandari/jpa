package com.xworkz.mobile.dto;


import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MobileStoreDTO {

    private Integer id;
    private String mobileName;
    private String brand;
    private Double price;
    private String color;

}