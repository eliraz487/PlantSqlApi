package com.example.demo.sensor.vo;


import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data

public class SensorTypeVSCheckVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Long id;

    @NotNull(message = "checkID can not null")
    private Long checkID;

    @NotNull(message = "sensorTypeID can not null")
    private Long sensorTypeID;

}
