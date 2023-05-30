package com.example.demo.sensor.controller;


import com.example.demo.sensor.service.SensorTypeVSCheckService;


import com.example.demo.sensor.vo.SensorTypeVSCheckVO;
import com.sun.istack.NotNull;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/SensorTypeVSCheck")
public class SensorTypeVSCheckController {

    @Autowired
    private SensorTypeVSCheckService SensorTypeVSCheckService;

    @PostMapping("/save")

    public String save(@Valid @RequestBody SensorTypeVSCheckVO vO) {
        return SensorTypeVSCheckService.save(vO).toString();
    }

    @DeleteMapping("")

    public String delete(@Valid @com.sun.istack.NotNull @RequestParam Long id) {
        return SensorTypeVSCheckService.delete(id);
    }

    @PutMapping("")

    public String update(@Valid @com.sun.istack.NotNull @RequestParam Long id,
                         @Valid @RequestBody SensorTypeVSCheckVO vO) {
        return SensorTypeVSCheckService.update(id, vO);
    }

    @GetMapping("")

    public SensorTypeVSCheckVO getById(@Valid @NotNull @RequestParam Long id) {
        return SensorTypeVSCheckService.getById(id);
    }

   /* @GetMapping
    public Page<SensorTypeVSCheckVO> query(@Valid SensorTypeVSCheckQueryVO vO) {
        return SensorTypeVSCheckService.query(vO);
    }*/
}
