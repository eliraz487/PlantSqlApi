package com.example.demo.plants.vo;


import lombok.Data;

import java.io.Serializable;


@Data

public class PlantTypeVO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;


    private String name;


    private String familyID;

    private String url;

    private String description;

}
