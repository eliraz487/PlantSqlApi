package com.example.demo.service;

import com.example.demo.entity.PlantType;
import com.example.demo.repository.PlantTypeRepository;
import com.example.demo.vo.PlantTypeVO;
import org.springframework.beans.BeanUtils;
import com.google.gson.Gson;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PlantTypeService {

    @Autowired
    private PlantTypeRepository plantTypeRepository;

    public String save(PlantTypeVO vO) {
        PlantType bean = new PlantType();
        BeanUtils.copyProperties(vO, bean);
        try {
            // code to save the entity
            bean = plantTypeRepository.save(bean);
        } catch (DataIntegrityViolationException ex) {
            return "failed : "+"\n" +ex.getMessage();
        }
        vO.setId(bean.getId());
        Gson gson=new Gson();
        return gson.toJson(vO);
    }


    public String delete(Long id) {
        Optional<PlantType> optionalEntity = plantTypeRepository.findById(id);
        if (!optionalEntity.isPresent()) {
            return "PlantType not found";
        }
        plantTypeRepository.delete(optionalEntity.get());
        return "PlantType deleted successfully";
    }

    public String update(Long id, PlantTypeVO vO) {
        String validerror="";
        if (!(validerror=isValidation(vO)).equals("")){
            return "failed : "+"\n" +validerror;
        }
        PlantType bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        plantTypeRepository.save(bean);
        Gson gson=new Gson();
        return gson.toJson(vO);
    }

    public PlantTypeVO getById(Long id) {
        PlantType original = requireOne(id);
        return toVO(original);
    }

/*
    public Page<PlantTypeVO> query(PlantTypeQueryVO vO) {
        throw new UnsupportedOperationException();
    }
*/

    private PlantTypeVO toVO(PlantType original) {
        PlantTypeVO bean = new PlantTypeVO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PlantType requireOne(Long id) {
        return plantTypeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
   private String isValidation(PlantTypeVO vO) {
        String result="";
      
        return result;
    }
}
