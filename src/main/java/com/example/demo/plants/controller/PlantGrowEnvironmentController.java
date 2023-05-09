package com.example.demo.plants.controller;

import com.example.demo.plants.service.PlantGrowEnvironmentService;
import com.example.demo.plants.vo.PlantGrowEnvironmentVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping("/plantGrowEnvironment")
public class PlantGrowEnvironmentController {

    @Autowired
    private PlantGrowEnvironmentService plantGrowEnvironmentService;

    @PostMapping
    public String save(@Valid @RequestBody PlantGrowEnvironmentVO vO) {
        return plantGrowEnvironmentService.save(vO);
    }

    @DeleteMapping("")
    public String delete(@Valid @NotNull @RequestParam("id") Long id) {
        return plantGrowEnvironmentService.delete(id);
    }

    @PutMapping("")
    public String update(@Valid @NotNull @RequestParam Long id,
                       @Valid @RequestBody PlantGrowEnvironmentVO vO) {
        return plantGrowEnvironmentService.update(id, vO);
    }



    @GetMapping("")

    public PlantGrowEnvironmentVO getById(@Valid @NotNull@RequestParam Long id) {
        return plantGrowEnvironmentService.getById(id);
    }

  /*  @GetMapping



    public Page<PlantGrowEnvironmentVO> query(@Valid PlantGrowEnvironmentQueryVO vO) {
        return plantGrowEnvironmentService.query(vO);
    }*/
}
