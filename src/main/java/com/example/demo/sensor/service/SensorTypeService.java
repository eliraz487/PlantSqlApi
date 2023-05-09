package com.example.demo.sensor.service;


import com.example.demo.sensor.entity.SensorType;
import com.example.demo.sensor.repository.SensorTypeRepository;
import com.example.demo.sensor.vo.SensorTypeVO;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SensorTypeService {

    @Autowired
    private SensorTypeRepository SensorTypeRepository;

    public SensorTypeService(SensorTypeRepository SensorTypeRepository) {
        this.SensorTypeRepository = SensorTypeRepository;
    }

    public String save(SensorTypeVO vO) {
        String validerror="";
        if (!(validerror=isValidation(vO)).equals("")){
            return "failed : "+"\n" +validerror;
        }
        SensorType bean = new SensorType();
        BeanUtils.copyProperties(vO, bean);
        try {
            // code to save the entity
            bean = SensorTypeRepository.save(bean);
        } catch (DataIntegrityViolationException ex) {
            return "failed : " + "\n" + ex.getMessage();
        }
        vO.setId(bean.getId());
        Gson gson = new Gson();
        return gson.toJson(vO);
    }




    public String delete(Long id) {
        Optional<SensorType> optionalEntity = SensorTypeRepository.findById(id);
        if (!optionalEntity.isPresent()) {
            return "SensorType not found";
        }
        SensorTypeRepository.delete(optionalEntity.get());
        return "SensorType deleted successfully";
    }


    public String update(Long id, SensorTypeVO vO) {
        String validerror="";
        if (!(validerror=isValidation(vO)).equals("")){
            return "failed : "+"\n" +validerror;
        }
        SensorType bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        SensorTypeRepository.save(bean);
        Gson gson=new Gson();
        return gson.toJson(vO);
    }

    public SensorTypeVO getById(Long id) {
        SensorType original = requireOne(id);
        return toVO(original);
    }

/*
    public Page<SensorTypeVO> query(SensorTypeQueryVO vO) {
        throw new UnsupportedOperationException();
    }
*/

    private SensorTypeVO toVO(SensorType original) {
        SensorTypeVO bean = new SensorTypeVO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private SensorType requireOne(Long id) {
        return SensorTypeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    private String isValidation(SensorTypeVO vO) {
        String result="";
        // TODO: 09/05/2023 add validation 
        return result;
    }
}
