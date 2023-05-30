package com.example.demo.plants.controller;

import com.example.demo.plants.service.AgesService;
import com.example.demo.plants.vo.AgesVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping("/ages")
public class AgesController {

    @Autowired
    private AgesService agesService;

    @PostMapping
    
    public String save(@Valid @RequestBody AgesVO vO) {

        return agesService.save(vO).toString();
    }

    @DeleteMapping("")
   
    public String delete(@Valid @NotNull@RequestParam Long id) {
        return agesService.delete(id);
    }

    @PutMapping("")
   
    public String update(@Valid @NotNull@RequestParam Long id,
                       @Valid @RequestBody AgesVO vO) {
        return agesService.update(id, vO);
    }

    @GetMapping("")

    public AgesVO getById(@Valid @NotNull@RequestParam Long id) {
        return agesService.getById(id);
    }

/*    @GetMapping
    public Page<AgesVO> query(@Valid AgesQueryVO vO) {
        return agesService.query(vO);
    }
*/
}
