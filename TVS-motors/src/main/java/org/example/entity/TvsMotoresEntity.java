package org.example.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "tvs_motors")
@ToString
@AllArgsConstructor
@NoArgsConstructor
// Select
@NamedQuery(name = "getAllTvs", query = "select t from TvsMotoresEntity t")
@NamedQuery(name = "findTvsMotorsByBrand", query = "select t from TvsMotoresEntity t where t.brand = :brand")

@NamedQuery(name = "findTvsMotorsByIdAndModelName", query = "select t from TvsMotoresEntity t where t.id = :id and t.modelName = :modelName")

@NamedQuery(name = "findTvsMotorsByIdAndCategory", query = "select t from TvsMotoresEntity t where t.id = :id and t.category = :category")

@NamedQuery(name = "findTvsMotorsByPriceAndBrand", query = "select t from TvsMotoresEntity t where t.price = :price and t.brand = :brand")
// Update
@NamedQuery(name = "updateTvsModelName", query = "update TvsMotoresEntity t set t.modelName = :modelName where t.id = :id")
@NamedQuery(name = "updateTvsPrice", query = "update TvsMotoresEntity t set t.price = :price where t.id = :id")

// Delete
@NamedQuery(name = "deleteTvs", query = "delete from TvsMotoresEntity t where t.id = :id")

public class TvsMotoresEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")

    private Integer id;
    @Column(name="modelName")
    private String modelName;
    @Column(name="brand")
    private String brand;
    @Column(name="category")
    private String category;
    @Column(name="price")
    private Double price;


}
