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
