package com.example.demo.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel("Save ")
public class WateringRequirementVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Long id;

    @NotNull(message = "ageID can not null")
    private Long ageID;

    @NotNull(message = "plantTypeID can not null")
    private Long plantTypeID;

    @NotNull(message = "phFrom can not null")
    private Float phFrom;

    @NotNull(message = "phTo can not null")
    private Float phTo;

    @NotNull(message = "soilMoistureFrom can not null")
    private Integer soilMoistureFrom;

    @NotNull(message = "soilMoistureTo can not null")
    private Integer soilMoistureTo;

}
