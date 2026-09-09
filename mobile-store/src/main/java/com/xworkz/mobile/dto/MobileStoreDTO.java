package com.xworkz.mobile.dto;


import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MobileStoreDTO {

    private Integer id;
    @NotNull(message = "Mobile name cannot be null")
    @Size(min = 3, max = 50, message = "Mobile name must be between 3 and 50 characters")
    private String mobileName;
    @NotNull(message = "Brand cannot be null")
    @Size(min = 3, max = 50, message = "Brand must be between 3 and 50 characters")
    private String brand;
    @NotNull(message = "Price cannot be null")
    @Min(value = 0, message = "Price cannot be negative")
    private Double price;
    @NotNull(message = "Color cannot be null")
    @Size(min = 3, max = 50, message = "Color must be between 3 and 50 characters")
    private String color;

}