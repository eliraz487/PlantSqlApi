package com.example.demo.controller;

import com.example.demo.service.PlantGrowEnvironmentService;
import com.example.demo.vo.PlantGrowEnvironmentVO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping("/plantGrowEnvironment")
public class PlantGrowEnvironmentController {

    @Autowired
    private PlantGrowEnvironmentService plantGrowEnvironmentService;

    @PostMapping
    
    public String save(@Valid @RequestBody PlantGrowEnvironmentVO vO) {
        return plantGrowEnvironmentService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
   
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        plantGrowEnvironmentService.delete(id);
    }

    @PutMapping("/{id}")
   
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PlantGrowEnvironmentVO vO) {
        plantGrowEnvironmentService.update(id, vO);
    }

    @GetMapping("/{id}")

    public PlantGrowEnvironmentVO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return plantGrowEnvironmentService.getById(id);
    }

  /*  @GetMapping

    public Page<PlantGrowEnvironmentVO> query(@Valid PlantGrowEnvironmentQueryVO vO) {
        return plantGrowEnvironmentService.query(vO);
    }*/
}
