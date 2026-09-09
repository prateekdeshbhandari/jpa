package com.xworkz.Library.dto;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LibraryDTO {

    private Integer id;
    @NotNull(message = "Book name cannot be null")
    @Size(min = 3, max = 50, message = "Book name must be between 3 and 50 characters")
    private String bookName;
    @NotNull(message = "Author name cannot be null")
    @Size(min = 3, max = 50, message = "Author name must be between 3 and 50 characters")
    private String authorName;
    @NotNull(message = "Category cannot be null")
    @Size(min = 3, max = 50, message = "Category must be between 3 and 50 characters")
    private String category;
    @NotNull(message = "Price cannot be null")
    @Min(value = 0, message = "Price cannot be negative")
    private Double price;





}
