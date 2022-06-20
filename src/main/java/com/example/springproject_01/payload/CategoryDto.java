package com.example.springproject_01.payload;

import lombok.Data;

@Data

public class CategoryDto {
    private String name;
    private Integer parentCategoryId;
}
