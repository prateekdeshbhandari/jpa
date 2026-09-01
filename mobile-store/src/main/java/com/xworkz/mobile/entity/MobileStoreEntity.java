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
// Select
@NamedQuery(name = "getAllMobileStores", query = "select m from MobileStoreEntity m")
@NamedQuery(name = "findMobileStoreByBrand", query = "select m from MobileStoreEntity m where m.brand = :brand")

@NamedQuery(name = "findMobileStoreByIdAndMobileName", query = "select m from MobileStoreEntity m where m.id = :id and m.mobileName = :mobileName")

@NamedQuery(name = "findMobileStoreByIdAndColor", query = "select m from MobileStoreEntity m where m.id = :id and m.color = :color")

@NamedQuery(name = "findMobileStoreByPriceAndBrand", query = "select m from MobileStoreEntity m where m.price = :price and m.brand = :brand")

// Update
@NamedQuery(name = "updateMobileName", query = "update MobileStoreEntity m set m.mobileName = :mobileName where m.id = :id")
@NamedQuery(name = "updateMobilePrice", query = "update MobileStoreEntity m set m.price = :price where m.id = :id")

// Delete
@NamedQuery(name = "deleteMobile", query = "delete from MobileStoreEntity m where m.id = :id")
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