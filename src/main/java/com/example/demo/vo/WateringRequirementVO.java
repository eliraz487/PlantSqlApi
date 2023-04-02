package com.example.demo.vo;

import com.sun.istack.NotNull;

import lombok.Data;

import java.io.Serializable;


@Data

public class WateringRequirementVO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;


    private Long ageID;


    private Long plantTypeID;


    private Float phFrom;


    private Float phTo;


    private Integer soilMoistureFrom;


    private Integer soilMoistureTo;

}
