package com.example.demo.sensor.controller;


import com.example.demo.sensor.service.SensorVSPlantsService;


import com.example.demo.sensor.vo.SensorVSPlantsVO;
import com.sun.istack.NotNull;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/SensorVSPlants")
public class SensorVSPlantsController {

    @Autowired
    private SensorVSPlantsService SensorVSPlantsService;

    @PostMapping("/save")

    public String save(@Valid @RequestBody SensorVSPlantsVO vO) {
        return SensorVSPlantsService.save(vO).toString();
    }

    @DeleteMapping("")

    public String delete(@Valid @com.sun.istack.NotNull @RequestParam Long id) {
        return SensorVSPlantsService.delete(id);
    }

    @PutMapping("")

    public String update(@Valid @com.sun.istack.NotNull @RequestParam Long id,
                         @Valid @RequestBody SensorVSPlantsVO vO) {
        return SensorVSPlantsService.update(id, vO);
    }

    @GetMapping("")

    public SensorVSPlantsVO getById(@Valid @NotNull @RequestParam Long id) {
        return SensorVSPlantsService.getById(id);
    }

   /* @GetMapping
    public Page<SensorVSPlantsVO> query(@Valid SensorVSPlantsQueryVO vO) {
        return SensorVSPlantsService.query(vO);
    }*/
}
