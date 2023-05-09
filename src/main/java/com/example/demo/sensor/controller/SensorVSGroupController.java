package com.example.demo.sensor.controller;


import com.example.demo.sensor.service.SensorVSGroupService;


import com.example.demo.sensor.vo.SensorVSGroupVO;
import com.sun.istack.NotNull;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/SensorVSGroup")
public class SensorVSGroupController {

    @Autowired
    private SensorVSGroupService SensorVSGroupService;

    @PostMapping("/save")

    public String save(@jakarta.validation.Valid @RequestBody SensorVSGroupVO vO) {
        return SensorVSGroupService.save(vO).toString();
    }

    @DeleteMapping("")

    public String delete(@jakarta.validation.Valid @com.sun.istack.NotNull @RequestParam Long id) {
        return SensorVSGroupService.delete(id);
    }

    @PutMapping("")

    public String update(@jakarta.validation.Valid @com.sun.istack.NotNull @RequestParam Long id,
                         @jakarta.validation.Valid @RequestBody SensorVSGroupVO vO) {
        return SensorVSGroupService.update(id, vO);
    }

    @GetMapping("")

    public SensorVSGroupVO getById(@Valid @NotNull @RequestParam Long id) {
        return SensorVSGroupService.getById(id);
    }

   /* @GetMapping
    public Page<SensorVSGroupVO> query(@Valid SensorVSGroupQueryVO vO) {
        return SensorVSGroupService.query(vO);
    }*/
}
