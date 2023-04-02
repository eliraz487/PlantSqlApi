package com.example.demo.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;


@Data

public class PlantVO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;


    private Long plantGroupID;


    private LocalDate plantingDate;


    private Long typeID;

    private String description;


    private Boolean isDeleted;

}
