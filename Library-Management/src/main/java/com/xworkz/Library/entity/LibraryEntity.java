package com.xworkz.Library.entity;



import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "library")
public class LibraryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private Double price;
}