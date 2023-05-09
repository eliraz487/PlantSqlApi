package com.example.demo.controller;

import com.example.demo.service.PlantService;
import com.example.demo.vo.PlantVO;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    private PlantService plantService;

    @PostMapping
    
    public String save(@Valid @RequestBody PlantVO vO) {
        return plantService.save(vO).toString();
    }

    @DeleteMapping("")
   
    public String delete(@Valid @NotNull@RequestParam Long id) {
        return plantService.delete(id);
    }

    @PutMapping("")
   
    public String update(@Valid @NotNull@RequestParam Long id,
                       @Valid @RequestBody PlantVO vO) {
        plantService.update(id, vO);
    }

    @GetMapping("")

    public PlantVO getById(@Valid @NotNull@RequestParam Long id) {
        return plantService.getById(id);
    }

 /*   @GetMapping
   
    public Page<PlantVO> query(@Valid PlantQueryVO vO) {
        return plantService.query(vO);
    }*/
}
