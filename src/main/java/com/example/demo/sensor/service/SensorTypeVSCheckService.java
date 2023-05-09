package com.example.demo.sensor.service;


import com.example.demo.sensor.entity.SensorTypeVSCheck;
import com.example.demo.sensor.repository.SensorTypeVSCheckRepository;
import com.example.demo.sensor.vo.SensorTypeVSCheckVO;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SensorTypeVSCheckService {

    @Autowired
    private SensorTypeVSCheckRepository SensorTypeVSCheckRepository;

    public SensorTypeVSCheckService(SensorTypeVSCheckRepository SensorTypeVSCheckRepository) {
        this.SensorTypeVSCheckRepository = SensorTypeVSCheckRepository;
    }

    public String save(SensorTypeVSCheckVO vO) {
        String validerror="";
        if (!(validerror=isValidation(vO)).equals("")){
            return "failed : "+"\n" +validerror;
        }
        SensorTypeVSCheck bean = new SensorTypeVSCheck();
        BeanUtils.copyProperties(vO, bean);
        try {
            // code to save the entity
            bean = SensorTypeVSCheckRepository.save(bean);
        } catch (DataIntegrityViolationException ex) {
            return "failed : " + "\n" + ex.getMessage();
        }
        vO.setId(bean.getId());
        Gson gson = new Gson();
        return gson.toJson(vO);
    }




    public String delete(Long id) {
        Optional<SensorTypeVSCheck> optionalEntity = SensorTypeVSCheckRepository.findById(id);
        if (!optionalEntity.isPresent()) {
            return "SensorTypeVSCheck not found";
        }
        SensorTypeVSCheckRepository.delete(optionalEntity.get());
        return "SensorTypeVSCheck deleted successfully";
    }


    public String update(Long id, SensorTypeVSCheckVO vO) {
        String validerror="";
        if (!(validerror=isValidation(vO)).equals("")){
            return "failed : "+"\n" +validerror;
        }
        SensorTypeVSCheck bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        SensorTypeVSCheckRepository.save(bean);
        Gson gson=new Gson();
        return gson.toJson(vO);
    }

    public SensorTypeVSCheckVO getById(Long id) {
        SensorTypeVSCheck original = requireOne(id);
        return toVO(original);
    }

/*
    public Page<SensorTypeVSCheckVO> query(SensorTypeVSCheckQueryVO vO) {
        throw new UnsupportedOperationException();
    }
*/

    private SensorTypeVSCheckVO toVO(SensorTypeVSCheck original) {
        SensorTypeVSCheckVO bean = new SensorTypeVSCheckVO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private SensorTypeVSCheck requireOne(Long id) {
        return SensorTypeVSCheckRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    private String isValidation(SensorTypeVSCheckVO vO) {
        String result="";
        return result;
    }
}
