package com.example.demo.sensor.vo;


import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class SensorVSPlantsVO implements Serializable {

    @NotNull(message = "id can not null")
    private Long id;

    @NotNull(message = "plantID can not null")
    private Long plantID;

    @NotNull(message = "sensorID can not null")
    private Long sensorID;

}
