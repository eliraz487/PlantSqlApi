package com.example.demo.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel("Save ")
public class PlantTypeVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Long id;

    @NotNull(message = "name can not null")
    private String name;

    @NotNull(message = "familyID can not null")
    private String familyID;

    private String url;

    private String description;

}
