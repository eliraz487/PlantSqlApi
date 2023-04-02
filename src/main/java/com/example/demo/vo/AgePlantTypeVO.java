package com.example.demo.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;


@Data
@ApiModel("Save ")
public class AgePlantTypeVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Long id;

    @NotNull(message = "plantTypeID can not null")
    private Long plantTypeID;

    @NotNull(message = "fromDate can not null")
    private LocalDate fromDate;

    @NotNull(message = "toDate can not null")
    private LocalDate toDate;

    @NotNull(message = "ages can not null")
    private Long ages;

}
