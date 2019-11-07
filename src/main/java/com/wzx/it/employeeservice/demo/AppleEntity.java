package com.wzx.it.employeeservice.demo;

import lombok.Data;

@Data
public class AppleEntity {
    private String color;
    private Integer weight;
    private String aFlag;

    public AppleEntity(String color, Integer weight, String aFlag) {
        this.color = color;
        this.weight = weight;
        this.aFlag = aFlag;
    }
}
