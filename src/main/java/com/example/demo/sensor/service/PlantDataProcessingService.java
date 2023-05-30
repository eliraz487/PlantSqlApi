package com.example.demo.sensor.service;


import com.example.demo.sensor.entity.PlantDataProcessing;
import com.example.demo.sensor.repository.PlantDataProcessingRepository;
import com.example.demo.sensor.vo.PlantDataProcessingVO;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PlantDataProcessingService {

    @Autowired
    private PlantDataProcessingRepository PlantDataProcessingRepository;

    public PlantDataProcessingService(PlantDataProcessingRepository PlantDataProcessingRepository) {
        this.PlantDataProcessingRepository = PlantDataProcessingRepository;
    }

    public String save(PlantDataProcessingVO vO) {
        String validerror="";
        if (!(validerror=isValidation(vO)).equals("")){
            return "failed : "+"\n" +validerror;
        }
        PlantDataProcessing bean = new PlantDataProcessing();
        BeanUtils.copyProperties(vO, bean);
        try {
            // code to save the entity
            bean = PlantDataProcessingRepository.save(bean);
        } catch (DataIntegrityViolationException ex) {
            return "failed : " + "\n" + ex.getMessage();
        }
        vO.setId(bean.getId());
        Gson gson = new Gson();
        return gson.toJson(vO);
    }




    public String delete(Long id) {
        Optional<PlantDataProcessing> optionalEntity = PlantDataProcessingRepository.findById(id);
        if (!optionalEntity.isPresent()) {
            return "PlantDataProcessing not found";
        }
        PlantDataProcessingRepository.delete(optionalEntity.get());
        return "PlantDataProcessing deleted successfully";
    }


    public String update(Long id, PlantDataProcessingVO vO) {
        String validerror="";
        if (!(validerror=isValidation(vO)).equals("")){
            return "failed : "+"\n" +validerror;
        }
        PlantDataProcessing bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        PlantDataProcessingRepository.save(bean);
        Gson gson=new Gson();
        return gson.toJson(vO);
    }

    public PlantDataProcessingVO getById(Long id) {
        PlantDataProcessing original = requireOne(id);
        return toVO(original);
    }

/*
    public Page<PlantDataProcessingVO> query(PlantDataProcessingQueryVO vO) {
        throw new UnsupportedOperationException();
    }
*/

    private PlantDataProcessingVO toVO(PlantDataProcessing original) {
        PlantDataProcessingVO bean = new PlantDataProcessingVO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PlantDataProcessing requireOne(Long id) {
        return PlantDataProcessingRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    private String isValidation(PlantDataProcessingVO vO) {
        String result="";
        // TODO: 09/05/2023 add validation 
        return result;
    }
}
