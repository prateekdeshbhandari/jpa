package com.xworkz.mobile.entity;



import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "mobile_store")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MobileStoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "mobile_name")
    private String mobileName;

    @Column(name = "brand")
    private String brand;

    @Column(name = "price")
    private Double price;

    @Column(name = "color")
    private String color;
}