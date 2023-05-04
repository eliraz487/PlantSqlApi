package com.example.demo.service;

import com.example.demo.entity.Plant;
import com.example.demo.repository.PlantRepository;
import com.example.demo.vo.PlantGrowEnvironmentVO;
import com.example.demo.vo.PlantVO;
import org.springframework.beans.BeanUtils;
import com.google.gson.Gson;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PlantService {

    @Autowired
    private PlantRepository plantRepository;

    public String save(PlantVO vO) {
        Plant bean = new Plant();
        BeanUtils.copyProperties(vO, bean);
        try {
            // code to save the entity
            bean = plantRepository.save(bean);
        } catch (DataIntegrityViolationException ex) {
            return "failed : "+"\n" +ex.getMessage();
        }
        vO.setId(bean.getId());
        Gson gson=new Gson();
        return gson.toJson(vO);
    }


    public String delete(Long id) {
        Optional<Plant> optionalEntity = plantRepository.findById(id);
        if (!optionalEntity.isPresent()) {
            return "Plant not found";
        }
        plantRepository.delete(optionalEntity.get());
        return "Plant deleted successfully";
    }

    public void update(Long id, PlantVO vO) {
        Plant bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        plantRepository.save(bean);
    }

    public PlantVO getById(Long id) {
        Plant original = requireOne(id);
        return toVO(original);
    }

/*
    public Page<PlantVO> query(PlantQueryVO vO) {
        throw new UnsupportedOperationException();
    }
*/

    private PlantVO toVO(Plant original) {
        PlantVO bean = new PlantVO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Plant requireOne(Long id) {
        return plantRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
    public ArrayList<Plant> getAllByPlantGrowEnvironmentID( Long id) {
        ArrayList<Plant> plants = new ArrayList<>();
        plants = plantRepository.getAllByPlantGrowEnvironmentID(id);
        return plants;
    }

    ArrayList<Plant> getAllByPlantGroupID( Long groupid){
        ArrayList<Plant> plants = new ArrayList<>();
        plants = plantRepository.getAllByPlantGroupID(groupid);
        return plants;
    }
   private String isValidation(Plant vO) {
        String result="";
      
        return result;
    }
}
