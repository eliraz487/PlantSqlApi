package com.example.demo.sensor.vo;


import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class PlantDataProcessingVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Integer id;

    @NotNull(message = "plantAgePlantTypeID can not null")
    private Long plantAgePlantTypeID;

    @NotNull(message = "checkID can not null")
    private Long checkID;

    @NotNull(message = "rangeOfChange can not null")
    private Float rangeOfChange;

    @NotNull(message = "lossingWater can not null")
    private Float lossingWater;

    @NotNull(message = "waterConsumption can not null")
    private Float waterConsumption;

}
