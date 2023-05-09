package com.example.demo.sensor.vo;


import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data

public class SensorTypeVSCheckValueVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Long id;

    @NotNull(message = "value can not null")
    private Float value;

    @NotNull(message = "valueTime can not null")
    private String valueTime;

    @NotNull(message = "sensorID can not null")
    private Long sensorID;

    @NotNull(message = "sensorTypeVSCheckID can not null")
    private Long sensorTypeVSCheckID;

}
