package com.example.demo.vo;



import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;


@Data
public class AgePlantTypeVO implements Serializable {
    private static final long serialVersionUID = 1L;

   
    private Long id;

 
    private Long plantTypeID;

  
    private LocalDate fromDate;


    private LocalDate toDate;


    private Long ages;

}
