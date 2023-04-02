package com.example.demo.controller;

import com.example.demo.service.WateringRequirementService;
import com.example.demo.vo.WateringRequirementVO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping("/wateringRequirement")
public class WateringRequirementController {

    @Autowired
    private WateringRequirementService wateringRequirementService;

    @PostMapping
    
    public String save(@Valid @RequestBody WateringRequirementVO vO) {
        return wateringRequirementService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
   
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        wateringRequirementService.delete(id);
    }

    @PutMapping("/{id}")
   
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody WateringRequirementVO vO) {
        wateringRequirementService.update(id, vO);
    }

    @GetMapping("/{id}")

    public WateringRequirementVO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return wateringRequirementService.getById(id);
    }

  /*  @GetMapping
   
    public Page<WateringRequirementVO> query(@Valid WateringRequirementQueryVO vO) {
        return wateringRequirementService.query(vO);
    }*/
}
