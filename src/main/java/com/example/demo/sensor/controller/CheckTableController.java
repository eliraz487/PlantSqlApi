package com.example.demo.sensor.controller;


import com.example.demo.sensor.service.CheckTableService;


import com.example.demo.sensor.vo.CheckTableVO;
import com.sun.istack.NotNull;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/CheckTable")
public class CheckTableController {

    @Autowired
    private CheckTableService CheckTableService;

    @PostMapping("/save")

    public String save(@Valid @RequestBody CheckTableVO vO) {
        return CheckTableService.save(vO).toString();
    }

    @DeleteMapping("")

    public String delete(@Valid @com.sun.istack.NotNull @RequestParam Long id) {
        return CheckTableService.delete(id);
    }

    @PutMapping("")

    public String update(@Valid @com.sun.istack.NotNull @RequestParam Long id,
                         @Valid @RequestBody CheckTableVO vO) {
        return CheckTableService.update(id, vO);
    }

    @GetMapping("")

    public CheckTableVO getById(@Valid @NotNull @RequestParam Long id) {
        return CheckTableService.getById(id);
    }

   /* @GetMapping
    public Page<CheckTableVO> query(@Valid CheckTableQueryVO vO) {
        return CheckTableService.query(vO);
    }*/
}
