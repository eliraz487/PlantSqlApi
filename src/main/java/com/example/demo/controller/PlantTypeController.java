package com.example.demo.controller;

import com.example.demo.service.PlantTypeService;
import com.example.demo.vo.PlantTypeVO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping("/plantType")
public class PlantTypeController {

    @Autowired
    private PlantTypeService plantTypeService;

    @PostMapping
    
    public String save(@Valid @RequestBody PlantTypeVO vO) {
        return plantTypeService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
   
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        plantTypeService.delete(id);
    }

    @PutMapping("/{id}")
   
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PlantTypeVO vO) {
        plantTypeService.update(id, vO);
    }

    @GetMapping("/{id}")

    public PlantTypeVO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return plantTypeService.getById(id);
    }

   /* @GetMapping
   
    public Page<PlantTypeVO> query(@Valid PlantTypeQueryVO vO) {
        return plantTypeService.query(vO);
    }*/
}
