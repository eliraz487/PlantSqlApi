package com.example.demo.sensor.controller;


import com.example.demo.sensor.service.SensorService;


import com.example.demo.sensor.vo.SensorVO;
import com.sun.istack.NotNull;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/Sensor")
public class SensorController {

    @Autowired
    private SensorService SensorService;

    @PostMapping("/save")

    public String save(@Valid @RequestBody SensorVO vO) {
        return SensorService.save(vO).toString();
    }

    @DeleteMapping("")

    public String delete(@Valid @com.sun.istack.NotNull @RequestParam Long id) {
        return SensorService.delete(id);
    }

    @PutMapping("")

    public String update(@Valid @com.sun.istack.NotNull @RequestParam Long id,
                         @Valid @RequestBody SensorVO vO) {
        return SensorService.update(id, vO);
    }

    @GetMapping("")

    public SensorVO getById(@Valid @NotNull @RequestParam Long id) {
        return SensorService.getById(id);
    }

   /* @GetMapping
    public Page<SensorVO> query(@Valid SensorQueryVO vO) {
        return SensorService.query(vO);
    }*/
}
