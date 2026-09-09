package org.example.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TvsMotorsDto {
    private int id;
    private String modelName;
    @NotNull(message = "Brand cannot be null")
    @Size(min = 2, max = 50, message = "Brand must be between 2 and 50 characters")
    private String brand;
    @NotNull(message = "Category cannot be null")
    @Size(min = 2, max = 50, message = "Category must be between 2 and 50 characters")
    private String category;
    @NotNull(message = "Price cannot be null")
    @Min(value = 0, message = "Price cannot be negative")
    private double price;
}