package com.example.demo.sensor.service;


import com.example.demo.sensor.entity.SensorVSPlants;
import com.example.demo.sensor.repository.SensorVSPlantsRepository;
import com.example.demo.sensor.vo.SensorVSPlantsVO;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SensorVSPlantsService {

    @Autowired
    private SensorVSPlantsRepository SensorVSPlantsRepository;

    public SensorVSPlantsService(SensorVSPlantsRepository SensorVSPlantsRepository) {
        this.SensorVSPlantsRepository = SensorVSPlantsRepository;
    }

    public String save(SensorVSPlantsVO vO) {
        String validerror="";
        if (!(validerror=isValidation(vO)).equals("")){
            return "failed : "+"\n" +validerror;
        }
        SensorVSPlants bean = new SensorVSPlants();
        BeanUtils.copyProperties(vO, bean);
        try {
            // code to save the entity
            bean = SensorVSPlantsRepository.save(bean);
        } catch (DataIntegrityViolationException ex) {
            return "failed : " + "\n" + ex.getMessage();
        }
        vO.setId(bean.getId());
        Gson gson = new Gson();
        return gson.toJson(vO);
    }




    public String delete(Long id) {
        Optional<SensorVSPlants> optionalEntity = SensorVSPlantsRepository.findById(id);
        if (!optionalEntity.isPresent()) {
            return "SensorVSPlants not found";
        }
        SensorVSPlantsRepository.delete(optionalEntity.get());
        return "SensorVSPlants deleted successfully";
    }


    public String update(Long id, SensorVSPlantsVO vO) {
        String validerror="";
        if (!(validerror=isValidation(vO)).equals("")){
            return "failed : "+"\n" +validerror;
        }
        SensorVSPlants bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        SensorVSPlantsRepository.save(bean);
        Gson gson=new Gson();
        return gson.toJson(vO);
    }

    public SensorVSPlantsVO getById(Long id) {
        SensorVSPlants original = requireOne(id);
        return toVO(original);
    }

/*
    public Page<SensorVSPlantsVO> query(SensorVSPlantsQueryVO vO) {
        throw new UnsupportedOperationException();
    }
*/

    private SensorVSPlantsVO toVO(SensorVSPlants original) {
        SensorVSPlantsVO bean = new SensorVSPlantsVO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private SensorVSPlants requireOne(Long id) {
        return SensorVSPlantsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    private String isValidation(SensorVSPlantsVO vO) {
        String result="";
        // TODO: 09/05/2023 add validation 
        return result;
    }
}
