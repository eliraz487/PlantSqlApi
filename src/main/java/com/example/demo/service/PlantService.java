package com.example.demo.service;

import com.example.demo.entity.Plant;
import com.example.demo.repository.PlantRepository;
import com.example.demo.vo.PlantVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@Service
public class PlantService {

    @Autowired
    private PlantRepository plantRepository;

    public Long save(PlantVO vO) {
        Plant bean = new Plant();
        BeanUtils.copyProperties(vO, bean);
        bean = plantRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        plantRepository.deleteById(id);
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
}
