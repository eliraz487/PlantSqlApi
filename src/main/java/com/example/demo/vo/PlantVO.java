package com.example.demo.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;


@Data
@ApiModel("Save ")
public class PlantVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Long id;

    @NotNull(message = "plantGroupID can not null")
    private Long plantGroupID;

    @NotNull(message = "plantingDate can not null")
    private LocalDate plantingDate;

    @NotNull(message = "typeID can not null")
    private Long typeID;

    private String description;

    @NotNull(message = "isDeleted can not null")
    private Boolean isDeleted;

}
