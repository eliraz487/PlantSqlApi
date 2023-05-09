package com.example.demo.plants.vo;


import lombok.Data;

import java.io.Serializable;


@Data

public class PlantGrowEnvironmentVO implements Serializable {


    private Long id;

    private String name;

    private Long userOwnerID;

}
