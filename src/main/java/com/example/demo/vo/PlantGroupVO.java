package com.example.demo.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel("Save ")
public class PlantGroupVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Long id;

    @NotNull(message = "plantGrowEnvironmentID can not null")
    private Long plantGrowEnvironmentID;

    @NotNull(message = "name can not null")
    private String name;

    @NotNull(message = "isDeleted can not null")
    private Boolean isDeleted;

    private String description;

}
