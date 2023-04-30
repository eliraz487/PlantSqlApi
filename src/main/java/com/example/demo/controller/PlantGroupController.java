package com.example.demo.controller;

import com.example.demo.service.PlantGroupService;
import com.example.demo.vo.PlantGroupVO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
   
    public void update(@Valid @NotNull@RequestParam Long id,
                       @Valid @RequestBody PlantGroupVO vO) {
        plantGroupService.update(id, vO);
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
