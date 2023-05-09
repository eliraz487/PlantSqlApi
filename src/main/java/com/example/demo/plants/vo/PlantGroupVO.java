package com.example.demo.plants.vo;


import lombok.Data;

import java.io.Serializable;


@Data

public class PlantGroupVO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;


    private Long plantGrowEnvironmentID;


    private String name;


    private Boolean isDeleted;

    private String description;

}
