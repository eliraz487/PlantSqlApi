package com.example.demo.vo;


import lombok.Data;

import java.io.Serializable;


@Data

public class PlantGrowEnvironmentVO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;


    private String name;


    private Boolean isDeleted;


    private Long userOwnerID;

}
