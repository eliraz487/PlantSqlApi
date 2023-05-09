package com.example.demo.sensor.vo;


import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data

public class SensorTypeVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Long id;

    @NotNull(message = "type can not null")
    private String type;

}
