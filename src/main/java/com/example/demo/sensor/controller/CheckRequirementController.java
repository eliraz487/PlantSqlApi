package com.example.demo.sensor.controller;

import com.example.demo.sensor.entity.CheckRequirement;
import com.example.demo.sensor.service.CheckRequirementService;
import com.example.demo.sensor.service.CheckRequirementService;
import com.example.demo.sensor.vo.CheckRequirementVO;
import com.example.demo.sensor.vo.CheckRequirementVO;
import com.sun.istack.NotNull;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Validated
@RestController
@RequestMapping("/CheckRequirement")
public class CheckRequirementController {

    @Autowired
    private CheckRequirementService CheckRequirementService;

    @PostMapping("/save")

    public String save(@Valid @RequestBody CheckRequirementVO vO) {
        return CheckRequirementService.save(vO).toString();
    }

    @DeleteMapping("")

    public String delete(@Valid @com.sun.istack.NotNull @RequestParam Long id) {
        return CheckRequirementService.delete(id);
    }

    @PutMapping("")

    public String update(@Valid @com.sun.istack.NotNull @RequestParam Long id,
                         @Valid @RequestBody CheckRequirementVO vO) {
        return CheckRequirementService.update(id, vO);
    }

    @GetMapping("")

    public CheckRequirementVO getById(@Valid @NotNull @RequestParam Long id) {
        return CheckRequirementService.getById(id);
    }

   /* @GetMapping
    public Page<CheckRequirementVO> query(@Valid CheckRequirementQueryVO vO) {
        return CheckRequirementService.query(vO);
    }*/
   @GetMapping("/getCheckRequirementByPlantID")
   ArrayList<CheckRequirement> getCheckRequirementByPlantID(  @RequestParam int plantID) {
       return CheckRequirementService.getCheckRequirementByPlantID(plantID);
   }
}
