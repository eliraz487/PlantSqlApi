package com.example.demo.plants.controller;

import com.example.demo.plants.service.AgePlantTypeService;
import com.example.demo.plants.vo.AgePlantTypeVO;
import com.sun.istack.NotNull;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping("/agePlantType")
public class AgePlantTypeController {

    @Autowired
    private AgePlantTypeService agePlantTypeService;

    @PostMapping("/save")
    
    public String save(@Valid @RequestBody AgePlantTypeVO vO) {
        return agePlantTypeService.save(vO).toString();
    }

    @DeleteMapping("")
   
    public String delete(@Valid @NotNull@RequestParam Long id) {
        return agePlantTypeService.delete(id);
    }

    @PutMapping("")
   
    public String update(@Valid @NotNull@RequestParam Long id,
                       @Valid @RequestBody AgePlantTypeVO vO) {
       return agePlantTypeService.update(id, vO);
    }

    @GetMapping("")

    public AgePlantTypeVO getById(@Valid @NotNull@RequestParam Long id) {
        return agePlantTypeService.getById(id);
    }

   /* @GetMapping
    public Page<AgePlantTypeVO> query(@Valid AgePlantTypeQueryVO vO) {
        return agePlantTypeService.query(vO);
    }*/
}
