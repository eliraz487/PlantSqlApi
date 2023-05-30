package com.example.demo.sensor.vo;


import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class CheckRequirementVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Long id;

    @NotNull(message = "agePlantTypeID can not null")
    private Long agePlantTypeID;

    private Integer checkID;

    private Integer maxRecommendValue;

    private Integer minRecommendValue;

    private Integer maxValidValue;

    private Integer minValidValue;

}
