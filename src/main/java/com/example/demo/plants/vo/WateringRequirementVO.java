package com.example.demo.plants.vo;

import lombok.Data;

import java.io.Serializable;


@Data
public class WateringRequirementVO implements Serializable {
    private Long id;

    private Long agePlantType;

    private Float waterAmountByHalfAnHour;

}
