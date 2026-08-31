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
@NamedQuery(name = "findTvsByModelName", query = "select t from TvsMotoresEntity t where t.modelName = :modelName")
@NamedQuery(name = "findTvsByBrand", query = "select t from TvsMotoresEntity t where t.brand = :brand")
@NamedQuery(name = "findTvsByCategory", query = "select t from TvsMotoresEntity t where t.category = :category")
@NamedQuery(name = "findTvsByPrice", query = "select t from TvsMotoresEntity t where t.price = :price")

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
