package com.example.demo.service;

import com.example.demo.entity.WateringRequirement;
import com.example.demo.repository.WateringRequirementRepository;
import com.example.demo.vo.WateringRequirementVO;
import org.springframework.beans.BeanUtils;
import com.google.gson.Gson;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class WateringRequirementService {

    @Autowired
    private WateringRequirementRepository wateringRequirementRepository;

    public String save(WateringRequirementVO vO) {
        WateringRequirement bean = new WateringRequirement();
        BeanUtils.copyProperties(bean, vO);
        try {
            // code to save the entity
            bean = wateringRequirementRepository.save(bean);
        } catch (DataIntegrityViolationException ex) {
            return "failed : "+"\n" +ex.getMessage();
        }
        vO.setId(bean.getId());
        Gson gson=new Gson();
        return gson.toJson(vO);
    }



    public String delete(Long id) {
        Optional<WateringRequirement> optionalEntity = wateringRequirementRepository.findById(id);
        if (!optionalEntity.isPresent()) {
            return "WateringRequirement not found";
        }
        wateringRequirementRepository.delete(optionalEntity.get());
        return "WateringRequirement deleted successfully";
    }

    public String update(Long id, WateringRequirementVO vO) {
        String validerror="";
        if (!(validerror=isValidation(vO)).equals("")){
            return "failed : "+"\n" +validerror;
        }
        WateringRequirement bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        wateringRequirementRepository.save(bean);
        Gson gson=new Gson();
        return gson.toJson(vO);
    }

    public WateringRequirementVO getById(Long id) {
        WateringRequirement original = requireOne(id);
        return toVO(original);
    }

/*    public Page<WateringRequirementVO> query(WateringRequirementVO vO) {
        throw new UnsupportedOperationException();
    }*/

    private WateringRequirementVO toVO(WateringRequirement original) {
        WateringRequirementVO bean = new WateringRequirementVO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private WateringRequirement requireOne(Long id) {
        return wateringRequirementRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
    private String isValidation(WateringRequirementVO vO) {
        String result="";

        return result;
    }
}
