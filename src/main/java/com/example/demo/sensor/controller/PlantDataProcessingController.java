package com.example.demo.sensor.controller;


import com.example.demo.sensor.service.PlantDataProcessingService;
import com.example.demo.sensor.vo.PlantDataProcessingVO;
import com.sun.istack.NotNull;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/PlantDataProcessing")
public class PlantDataProcessingController {

    @Autowired
    private PlantDataProcessingService PlantDataProcessingService;

    @PostMapping("/save")

    public String save(@Valid @RequestBody PlantDataProcessingVO vO) {
        return PlantDataProcessingService.save(vO).toString();
    }

    @DeleteMapping("")

    public String delete(@Valid @com.sun.istack.NotNull @RequestParam Long id) {
        return PlantDataProcessingService.delete(id);
    }

    @PutMapping("")

    public String update(@Valid @com.sun.istack.NotNull @RequestParam Long id,
                         @Valid @RequestBody PlantDataProcessingVO vO) {
        return PlantDataProcessingService.update(id, vO);
    }

    @GetMapping("")

    public PlantDataProcessingVO getById(@Valid @NotNull @RequestParam Long id) {
        return PlantDataProcessingService.getById(id);
    }

   /* @GetMapping
    public Page<PlantDataProcessingVO> query(@Valid PlantDataProcessingQueryVO vO) {
        return PlantDataProcessingService.query(vO);
    }*/
}
