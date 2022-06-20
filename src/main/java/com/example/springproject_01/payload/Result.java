package com.example.springproject_01.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private String massage;
    private boolean success;
    private Object object;

    public Result(String massage, boolean success) {
        this.massage = massage;
        this.success = success;
    }
}
