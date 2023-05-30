package com.example.demo.sensor.service;

import com.example.demo.sensor.entity.CheckRequirement;
import com.example.demo.sensor.entity.CheckRequirement;
import com.example.demo.sensor.repository.CheckRequirementRepository;
import com.example.demo.sensor.repository.CheckRequirementRepository;
import com.example.demo.sensor.vo.CheckRequirementVO;
import com.example.demo.sensor.vo.CheckRequirementVO;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CheckRequirementService {

    @Autowired
    private CheckRequirementRepository CheckRequirementRepository;

    public CheckRequirementService(CheckRequirementRepository CheckRequirementRepository) {
        this.CheckRequirementRepository = CheckRequirementRepository;
    }

    public String save(CheckRequirementVO vO) {
        String validerror="";
        if (!(validerror=isValidation(vO)).equals("")){
            return "failed : "+"\n" +validerror;
        }
        CheckRequirement bean = new CheckRequirement();
        BeanUtils.copyProperties(vO, bean);
        try {
            // code to save the entity
            bean = CheckRequirementRepository.save(bean);
        } catch (DataIntegrityViolationException ex) {
            return "failed : " + "\n" + ex.getMessage();
        }
        vO.setId(bean.getId());
        Gson gson = new Gson();
        return gson.toJson(vO);
    }




    public String delete(Long id) {
        Optional<CheckRequirement> optionalEntity = CheckRequirementRepository.findById(id);
        if (!optionalEntity.isPresent()) {
            return "CheckRequirement not found";
        }
        CheckRequirementRepository.delete(optionalEntity.get());
        return "CheckRequirement deleted successfully";
    }


    public String update(Long id, CheckRequirementVO vO) {
        String validerror="";
        if (!(validerror=isValidation(vO)).equals("")){
            return "failed : "+"\n" +validerror;
        }
        CheckRequirement bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        CheckRequirementRepository.save(bean);
        Gson gson=new Gson();
        return gson.toJson(vO);
    }

    public CheckRequirementVO getById(Long id) {
        CheckRequirement original = requireOne(id);
        return toVO(original);
    }

/*
    public Page<CheckRequirementVO> query(CheckRequirementQueryVO vO) {
        throw new UnsupportedOperationException();
    }
*/

    private CheckRequirementVO toVO(CheckRequirement original) {
        CheckRequirementVO bean = new CheckRequirementVO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CheckRequirement requireOne(Long id) {
        return CheckRequirementRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    private String isValidation(CheckRequirementVO vO) {
        String result="";
        // TODO: 09/05/2023 add validation 
        return result;
    }
    public ArrayList<CheckRequirement> getCheckRequirementByPlantID(int plantID) {
        return CheckRequirementRepository.getCheckRequirementByPlantID(plantID);
    }
}
