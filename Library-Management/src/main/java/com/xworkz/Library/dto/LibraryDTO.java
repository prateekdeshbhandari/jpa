package com.xworkz.Library.dto;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LibraryDTO {

    private Integer id;
    private String bookName;
    private String authorName;
    private String category;
    private Double price;
}
