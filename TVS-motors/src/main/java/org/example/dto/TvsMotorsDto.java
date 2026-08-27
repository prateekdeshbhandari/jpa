package org.example.dto;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TvsMotorsDto {
    private int id;
    private String modelName;
    private String brand;
    private String category;
    private double price;
}
