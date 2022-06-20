package com.example.springproject_01.payload;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class OutputDto {
    private Long date;
    private Integer warehouseId;
    private Integer clentId;
    private Integer currencyId;
    private String facturaNumber;
    private String code;
}
