package com.example.demo.sensor.service;


import com.example.demo.sensor.entity.CheckTable;
import com.example.demo.sensor.repository.CheckTableRepository;
import com.example.demo.sensor.vo.CheckTableVO;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CheckTableService {

    @Autowired
    private CheckTableRepository CheckTableRepository;

    public CheckTableService(CheckTableRepository CheckTableRepository) {
        this.CheckTableRepository = CheckTableRepository;
    }

    public String save(CheckTableVO vO) {
        String validerror="";
        if (!(validerror=isValidation(vO)).equals("")){
            return "failed : "+"\n" +validerror;
        }
        CheckTable bean = new CheckTable();
        BeanUtils.copyProperties(vO, bean);
        try {
            // code to save the entity
            bean = CheckTableRepository.save(bean);
        } catch (DataIntegrityViolationException ex) {
            return "failed : " + "\n" + ex.getMessage();
        }
        vO.setId(bean.getId());
        Gson gson = new Gson();
        return gson.toJson(vO);
    }




    public String delete(Long id) {
        Optional<CheckTable> optionalEntity = CheckTableRepository.findById(id);
        if (!optionalEntity.isPresent()) {
            return "CheckTable not found";
        }
        CheckTableRepository.delete(optionalEntity.get());
        return "CheckTable deleted successfully";
    }


    public String update(Long id, CheckTableVO vO) {
        String validerror="";
        if (!(validerror=isValidation(vO)).equals("")){
            return "failed : "+"\n" +validerror;
        }
        CheckTable bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        CheckTableRepository.save(bean);
        Gson gson=new Gson();
        return gson.toJson(vO);
    }

    public CheckTableVO getById(Long id) {
        CheckTable original = requireOne(id);
        return toVO(original);
    }

/*
    public Page<CheckTableVO> query(CheckTableQueryVO vO) {
        throw new UnsupportedOperationException();
    }
*/

    private CheckTableVO toVO(CheckTable original) {
        CheckTableVO bean = new CheckTableVO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CheckTable requireOne(Long id) {
        return CheckTableRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    private String isValidation(CheckTableVO vO) {
        String result="";
        // TODO: 09/05/2023 add validation 
        return result;
    }
}
