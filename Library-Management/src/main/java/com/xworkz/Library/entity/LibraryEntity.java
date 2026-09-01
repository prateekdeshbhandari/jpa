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
// Select
@NamedQuery(name = "getAllLibraryBooks", query = "select l from LibraryEntity l")

@NamedQuery(name = "getAllLibraryBookss", query = "select l from LibraryEntity l where l.authorName = :AuthorName ")

@NamedQuery(name = "findLibraryBookByBookName", query = "select l from LibraryEntity l where l.id = :id and l.bookName = :bookName"
)
@NamedQuery(name = "findLibraryBookByIdAndcategory", query = "select l from LibraryEntity l where l.id = :id and l.category = :category")
// Update
@NamedQuery(name = "updateLibraryBookName", query = "update LibraryEntity l set l.bookName = :bookName where l.id = :id")
@NamedQuery(name = "updateLibraryBookPrice", query = "update LibraryEntity l set l.price = :price where l.id = :id")

// Delete
@NamedQuery(name = "deleteLibraryBook", query = "delete from LibraryEntity l where l.id = :id")
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