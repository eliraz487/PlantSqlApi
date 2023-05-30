package com.example.demo.sensor.controller;


import com.example.demo.sensor.service.SensorTypeVSCheckValueService;


import com.example.demo.sensor.vo.SensorTypeVSCheckValueVO;
import com.sun.istack.NotNull;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/SensorTypeVSCheckValue")
public class SensorTypeVSCheckValueController {

    @Autowired
    private SensorTypeVSCheckValueService SensorTypeVSCheckValueService;

    @PostMapping("/save")

    public String save(@Valid @RequestBody SensorTypeVSCheckValueVO vO) {
        return SensorTypeVSCheckValueService.save(vO).toString();
    }

    @DeleteMapping("")

    public String delete(@Valid @com.sun.istack.NotNull @RequestParam Long id) {
        return SensorTypeVSCheckValueService.delete(id);
    }

    @PutMapping("")

    public String update(@Valid @com.sun.istack.NotNull @RequestParam Long id,
                         @Valid @RequestBody SensorTypeVSCheckValueVO vO) {
        return SensorTypeVSCheckValueService.update(id, vO);
    }

    @GetMapping("")

    public SensorTypeVSCheckValueVO getById(@Valid @NotNull @RequestParam Long id) {
        return SensorTypeVSCheckValueService.getById(id);
    }

   /* @GetMapping
    public Page<SensorTypeVSCheckValueVO> query(@Valid SensorTypeVSCheckValueQueryVO vO) {
        return SensorTypeVSCheckValueService.query(vO);
    }*/
}
