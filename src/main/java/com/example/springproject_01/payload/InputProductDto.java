package com.example.springproject_01.payload;

import lombok.Data;

@Data
public class InputProductDto {
    private Integer product;
    private Double amount; //miqdori
    private Double price;
    private String expireDate;//Format{"dd/MM/yy"}
    private Integer inputId;
}
