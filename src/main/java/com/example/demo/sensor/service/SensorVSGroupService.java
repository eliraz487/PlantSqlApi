package com.example.demo.sensor.service;


import com.example.demo.sensor.entity.SensorVSGroup;
import com.example.demo.sensor.repository.SensorVSGroupRepository;
import com.example.demo.sensor.vo.SensorVSGroupVO;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SensorVSGroupService {

    @Autowired
    private SensorVSGroupRepository SensorVSGroupRepository;

    public SensorVSGroupService(SensorVSGroupRepository SensorVSGroupRepository) {
        this.SensorVSGroupRepository = SensorVSGroupRepository;
    }

    public String save(SensorVSGroupVO vO) {
        String validerror="";
        if (!(validerror=isValidation(vO)).equals("")){
            return "failed : "+"\n" +validerror;
        }
        SensorVSGroup bean = new SensorVSGroup();
        BeanUtils.copyProperties(vO, bean);
        try {
            // code to save the entity
            bean = SensorVSGroupRepository.save(bean);
        } catch (DataIntegrityViolationException ex) {
            return "failed : " + "\n" + ex.getMessage();
        }
        vO.setId(bean.getId());
        Gson gson = new Gson();
        return gson.toJson(vO);
    }




    public String delete(Long id) {
        Optional<SensorVSGroup> optionalEntity = SensorVSGroupRepository.findById(id);
        if (!optionalEntity.isPresent()) {
            return "SensorVSGroup not found";
        }
        SensorVSGroupRepository.delete(optionalEntity.get());
        return "SensorVSGroup deleted successfully";
    }


    public String update(Long id, SensorVSGroupVO vO) {
        String validerror="";
        if (!(validerror=isValidation(vO)).equals("")){
            return "failed : "+"\n" +validerror;
        }
        SensorVSGroup bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        SensorVSGroupRepository.save(bean);
        Gson gson=new Gson();
        return gson.toJson(vO);
    }

    public SensorVSGroupVO getById(Long id) {
        SensorVSGroup original = requireOne(id);
        return toVO(original);
    }

/*
    public Page<SensorVSGroupVO> query(SensorVSGroupQueryVO vO) {
        throw new UnsupportedOperationException();
    }
*/

    private SensorVSGroupVO toVO(SensorVSGroup original) {
        SensorVSGroupVO bean = new SensorVSGroupVO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private SensorVSGroup requireOne(Long id) {
        return SensorVSGroupRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    private String isValidation(SensorVSGroupVO vO) {
        String result="";
        // TODO: 09/05/2023 add validation 
        return result;
    }
}
