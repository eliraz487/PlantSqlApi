package com.example.demo.plants.controller;

import com.example.demo.plants.service.PlantTypeService;
import com.example.demo.plants.vo.PlantTypeVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping("/plantType")
public class PlantTypeController {

    @Autowired
    private PlantTypeService plantTypeService;

    @PostMapping
    
    public String save(@Valid @RequestBody PlantTypeVO vO) {
        return plantTypeService.save(vO).toString();
    }

    @DeleteMapping("")
   
    public String delete(@Valid @NotNull @RequestParam Long id) {
        return plantTypeService.delete(id);
    }

    @PutMapping("")
   
    public String update(@Valid @NotNull @RequestParam Long id,
                       @Valid @RequestBody PlantTypeVO vO) {
        return plantTypeService.update(id, vO);
    }

    @GetMapping("")

    public PlantTypeVO getById(@Valid @NotNull @RequestParam Long id) {
        return plantTypeService.getById(id);
    }

   /* @GetMapping
   
    public Page<PlantTypeVO> query(@Valid PlantTypeQueryVO vO) {
        return plantTypeService.query(vO);
    }*/
}
