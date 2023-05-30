package com.example.demo.sensor.controller;


import com.example.demo.sensor.service.SensorTypeService;


import com.example.demo.sensor.vo.SensorTypeVO;
import com.sun.istack.NotNull;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/SensorType")
public class SensorTypeController {

    @Autowired
    private SensorTypeService SensorTypeService;

    @PostMapping("/save")

    public String save(@Valid @RequestBody SensorTypeVO vO) {
        return SensorTypeService.save(vO).toString();
    }

    @DeleteMapping("")

    public String delete(@Valid @com.sun.istack.NotNull @RequestParam Long id) {
        return SensorTypeService.delete(id);
    }

    @PutMapping("")

    public String update(@Valid @com.sun.istack.NotNull @RequestParam Long id,
                         @Valid @RequestBody SensorTypeVO vO) {
        return SensorTypeService.update(id, vO);
    }

    @GetMapping("")

    public SensorTypeVO getById(@Valid @NotNull @RequestParam Long id) {
        return SensorTypeService.getById(id);
    }

   /* @GetMapping
    public Page<SensorTypeVO> query(@Valid SensorTypeQueryVO vO) {
        return SensorTypeService.query(vO);
    }*/
}
