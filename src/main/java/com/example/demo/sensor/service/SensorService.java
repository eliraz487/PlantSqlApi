package com.example.demo.sensor.service;


import com.example.demo.sensor.entity.Sensor;
import com.example.demo.sensor.repository.SensorRepository;
import com.example.demo.sensor.vo.SensorVO;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SensorService {

    @Autowired
    private SensorRepository SensorRepository;

    public SensorService(SensorRepository SensorRepository) {
        this.SensorRepository = SensorRepository;
    }

    public String save(SensorVO vO) {
        String validerror="";
        if (!(validerror=isValidation(vO)).equals("")){
            return "failed : "+"\n" +validerror;
        }
        Sensor bean = new Sensor();
        BeanUtils.copyProperties(vO, bean);
        try {
            // code to save the entity
            bean = SensorRepository.save(bean);
        } catch (DataIntegrityViolationException ex) {
            return "failed : " + "\n" + ex.getMessage();
        }
        vO.setId(bean.getId());
        Gson gson = new Gson();
        return gson.toJson(vO);
    }




    public String delete(Long id) {
        Optional<Sensor> optionalEntity = SensorRepository.findById(id);
        if (!optionalEntity.isPresent()) {
            return "Sensor not found";
        }
        SensorRepository.delete(optionalEntity.get());
        return "Sensor deleted successfully";
    }


    public String update(Long id, SensorVO vO) {
        String validerror="";
        if (!(validerror=isValidation(vO)).equals("")){
            return "failed : "+"\n" +validerror;
        }
        Sensor bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        SensorRepository.save(bean);
        Gson gson=new Gson();
        return gson.toJson(vO);
    }

    public SensorVO getById(Long id) {
        Sensor original = requireOne(id);
        return toVO(original);
    }

/*
    public Page<SensorVO> query(SensorQueryVO vO) {
        throw new UnsupportedOperationException();
    }
*/

    private SensorVO toVO(Sensor original) {
        SensorVO bean = new SensorVO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Sensor requireOne(Long id) {
        return SensorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    private String isValidation(SensorVO vO) {
        String result="";
        // TODO: 09/05/2023 add validation 
        return result;
    }
}
