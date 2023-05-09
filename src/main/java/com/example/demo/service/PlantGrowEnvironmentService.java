package com.example.demo.service;

import com.example.demo.entity.PlantGrowEnvironment;
import com.example.demo.repository.PlantGrowEnvironmentRepository;
import com.example.demo.vo.PlantGrowEnvironmentVO;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class PlantGrowEnvironmentService {

    @Autowired
    private PlantGrowEnvironmentRepository plantGrowEnvironmentRepository;

    public String save(PlantGrowEnvironmentVO vO) {
        String validerror="";
        if (!(validerror=isValidation(vO)).equals("")){
            return "failed : "+"\n" +validerror;
        }
        PlantGrowEnvironment bean = new PlantGrowEnvironment();
        BeanUtils.copyProperties(vO, bean);
        try {
            // code to save the entity
            bean = plantGrowEnvironmentRepository.save(bean);
        } catch (DataIntegrityViolationException ex) {
            return "failed : "+"\n" +ex.getMessage();
        }
        vO.setId(bean.getId());
        Gson gson=new Gson();
        return gson.toJson(vO);
    }

    private String isValidation(PlantGrowEnvironmentVO vO) {
        String result="";
        Optional<Long> id= Optional.ofNullable(vO.getUserOwnerID());
        if (!id.isPresent()){
            result = result + "userOwnerID can be null";
        }
        return result;
    }


    public String delete(Long id) {
        Optional<PlantGrowEnvironment> optionalEntity = plantGrowEnvironmentRepository.findById(id);
        if (!optionalEntity.isPresent()) {
            return "PlantGrowEnvironment not found";
        }
        plantGrowEnvironmentRepository.delete(optionalEntity.get());
        return "PlantGrowEnvironment deleted successfully";
    }

    public String update(Long id, PlantGrowEnvironmentVO vO) {
        String validerror="";
        if (!(validerror=isValidation(vO)).equals("")){
            return "failed : "+"\n" +validerror;
        }
        PlantGrowEnvironment bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        plantGrowEnvironmentRepository.save(bean);
        Gson gson=new Gson();
        return gson.toJson(vO);
    }

    public PlantGrowEnvironmentVO getById(Long id) {
        PlantGrowEnvironment original = requireOne(id);
        return toVO(original);
    }

//    public Page<PlantGrowEnvironmentVO> query(PlantGrowEnvironmentQueryVO vO) {
//        throw new UnsupportedOperationException();
//    }

    private PlantGrowEnvironmentVO toVO(PlantGrowEnvironment original) {
        PlantGrowEnvironmentVO bean = new PlantGrowEnvironmentVO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PlantGrowEnvironment requireOne(Long id) {
        return plantGrowEnvironmentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }




    //findByNameAndUserOwnerID
    public ArrayList<PlantGrowEnvironment> findByNameAndUserOwnerID(Long ownerID){
        ArrayList<PlantGrowEnvironment> ownerplantGrowEnvironments=new ArrayList<>();
        ownerplantGrowEnvironments=plantGrowEnvironmentRepository.getAllUserPlantGrowEnvironment(ownerID);
        return ownerplantGrowEnvironments;
    }
// getAllUserPlantGrowEnvironment
    public Optional<PlantGrowEnvironmentVO> getByNameAndUserID(String name, Long ownerID){
        Optional<PlantGrowEnvironmentVO> plantGrowEnvironment;
        plantGrowEnvironment =plantGrowEnvironmentRepository.findByNameAndUserOwnerID(name,ownerID);
        return plantGrowEnvironment;
    }
}
