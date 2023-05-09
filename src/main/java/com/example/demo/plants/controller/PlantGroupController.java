package com.example.demo.plants.controller;

import com.example.demo.plants.service.PlantGroupService;
import com.example.demo.plants.vo.PlantGroupVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping("/plantGroup")
public class PlantGroupController {

    @Autowired
    private PlantGroupService plantGroupService;

    @PostMapping
    
    public String save(@Valid @RequestBody PlantGroupVO vO) {
        return plantGroupService.save(vO).toString();
    }

    @DeleteMapping("")
   
    public String delete(@Valid @NotNull@RequestParam Long id) {
        return plantGroupService.delete(id);
    }

    @PutMapping("")
   
    public String update(@Valid @NotNull@RequestParam Long id,
                       @Valid @RequestBody PlantGroupVO vO) {
        return plantGroupService.update(id, vO);
    }

    @GetMapping("")

    public PlantGroupVO getById(@Valid @NotNull@RequestParam Long id) {
        return plantGroupService.getById(id);
    }

    /*@GetMapping
   
    public Page<PlantGroupVO> query(@Valid PlantGroupQueryVO vO) {
        return plantGroupService.query(vO);
    }*/
}
