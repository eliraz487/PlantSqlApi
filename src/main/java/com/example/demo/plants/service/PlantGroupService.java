package com.example.demo.plants.service;


import com.example.demo.plants.entity.PlantGroup;
import com.example.demo.plants.repository.PlantGroupRepository;
import com.example.demo.plants.vo.PlantGroupVO;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PlantGroupService {

    @Autowired
    private PlantGroupRepository plantGroupRepository;

    public String save(PlantGroupVO vO) {
        PlantGroup bean = new PlantGroup();
        BeanUtils.copyProperties(vO, bean);
        try {
            // code to save the entity
            bean = plantGroupRepository.save(bean);
        } catch (DataIntegrityViolationException ex) {
            return "failed : "+"\n" +ex.getMessage();
        }
        vO.setId(bean.getId());
        Gson gson=new Gson();
        return gson.toJson(vO);
    }


    public String delete(Long id) {
        Optional<PlantGroup> optionalEntity = plantGroupRepository.findById(id);
        if (!optionalEntity.isPresent()) {
            return "PlantGroup not found";
        }
        plantGroupRepository.delete(optionalEntity.get());
        return "PlantGroup deleted successfully";
    }

    public String update(Long id, PlantGroupVO vO) {
        String validerror="";
        if (!(validerror=isValidation(vO)).equals("")){
            return "failed : "+"\n" +validerror;
        }
        PlantGroup bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        plantGroupRepository.save(bean);
        Gson gson=new Gson();
        return gson.toJson(vO);
    }

    public PlantGroupVO getById(Long id) {
        PlantGroup original = requireOne(id);
        return toVO(original);
    }

//    public Page<PlantGroupVO> query(PlantGroupQueryVO vO) {
//        throw new UnsupportedOperationException();
//    }

    private PlantGroupVO toVO(PlantGroup original) {
        PlantGroupVO bean = new PlantGroupVO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PlantGroup requireOne(Long id) {
        return plantGroupRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
    //getByNameAndPlantGrowEnvironmentID
    public PlantGroup getByNameAndPlantGrowEnvironmentID(String name, Long id){
        PlantGroup plantGroup=new PlantGroup();
        plantGroup=plantGroupRepository.getByNameAndPlantGrowEnvironmentID(name,id);
        return plantGroup;
    }
    //getAllPlantGroupByPlantGrowEnvironmentID

    public ArrayList<PlantGroup> getAllPlantGroupByPlantGrowEnvironmentID(Long id){
        ArrayList<PlantGroup> ownerPlantGroups=new ArrayList<>();
        ownerPlantGroups=plantGroupRepository.getAllPlantGroupByPlantGrowEnvironmentID(id);
        return ownerPlantGroups;
    }

   private String isValidation(PlantGroupVO vO) {
        String result="";
      
        return result;
    }
}
