package com.example.demo.sensor.service;


import com.example.demo.sensor.entity.SensorTypeVSCheckValue;
import com.example.demo.sensor.repository.SensorTypeVSCheckValueRepository;
import com.example.demo.sensor.vo.SensorTypeVSCheckValueVO;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SensorTypeVSCheckValueService {

    @Autowired
    private SensorTypeVSCheckValueRepository SensorTypeVSCheckValueRepository;

    public SensorTypeVSCheckValueService(SensorTypeVSCheckValueRepository SensorTypeVSCheckValueRepository) {
        this.SensorTypeVSCheckValueRepository = SensorTypeVSCheckValueRepository;
    }

    public String save(SensorTypeVSCheckValueVO vO) {
        String validerror="";
        if (!(validerror=isValidation(vO)).equals("")){
            return "failed : "+"\n" +validerror;
        }
        SensorTypeVSCheckValue bean = new SensorTypeVSCheckValue();
        BeanUtils.copyProperties(vO, bean);
        try {
            // code to save the entity
            bean = SensorTypeVSCheckValueRepository.save(bean);
        } catch (DataIntegrityViolationException ex) {
            return "failed : " + "\n" + ex.getMessage();
        }
        vO.setId(bean.getId());
        Gson gson = new Gson();
        return gson.toJson(vO);
    }




    public String delete(Long id) {
        Optional<SensorTypeVSCheckValue> optionalEntity = SensorTypeVSCheckValueRepository.findById(id);
        if (!optionalEntity.isPresent()) {
            return "SensorTypeVSCheckValue not found";
        }
        SensorTypeVSCheckValueRepository.delete(optionalEntity.get());
        return "SensorTypeVSCheckValue deleted successfully";
    }


    public String update(Long id, SensorTypeVSCheckValueVO vO) {
        String validerror="";
        if (!(validerror=isValidation(vO)).equals("")){
            return "failed : "+"\n" +validerror;
        }
        SensorTypeVSCheckValue bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        SensorTypeVSCheckValueRepository.save(bean);
        Gson gson=new Gson();
        return gson.toJson(vO);
    }

    public SensorTypeVSCheckValueVO getById(Long id) {
        SensorTypeVSCheckValue original = requireOne(id);
        return toVO(original);
    }

/*
    public Page<SensorTypeVSCheckValueVO> query(SensorTypeVSCheckValueQueryVO vO) {
        throw new UnsupportedOperationException();
    }
*/

    private SensorTypeVSCheckValueVO toVO(SensorTypeVSCheckValue original) {
        SensorTypeVSCheckValueVO bean = new SensorTypeVSCheckValueVO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private SensorTypeVSCheckValue requireOne(Long id) {
        return SensorTypeVSCheckValueRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    private String isValidation(SensorTypeVSCheckValueVO vO) {
        String result="";
        // TODO: 09/05/2023 add validation 
        return result;
    }
}
