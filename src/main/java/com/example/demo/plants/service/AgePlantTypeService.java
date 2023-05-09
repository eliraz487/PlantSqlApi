package com.example.demo.plants.service;

import com.example.demo.plants.entity.AgePlantType;
import com.example.demo.plants.repository.AgePlantTypeRepository;
import com.example.demo.plants.vo.AgePlantTypeVO;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AgePlantTypeService {

    @Autowired
    private AgePlantTypeRepository agePlantTypeRepository;

    public AgePlantTypeService(AgePlantTypeRepository agePlantTypeRepository) {
        this.agePlantTypeRepository = agePlantTypeRepository;
    }

    public String save(AgePlantTypeVO vO) {
        String validerror="";
        if (!(validerror=isValidation(vO)).equals("")){
            return "failed : "+"\n" +validerror;
        }
        AgePlantType bean = new AgePlantType();
        BeanUtils.copyProperties(vO, bean);
        try {
            // code to save the entity
            bean = agePlantTypeRepository.save(bean);
        } catch (DataIntegrityViolationException ex) {
            return "failed : " + "\n" + ex.getMessage();
        }
        vO.setId(bean.getId());
        Gson gson = new Gson();
        return gson.toJson(vO);
    }

   


    public String delete(Long id) {
        Optional<AgePlantType> optionalEntity = agePlantTypeRepository.findById(id);
        if (!optionalEntity.isPresent()) {
            return "AgePlantType not found";
        }
        agePlantTypeRepository.delete(optionalEntity.get());
        return "AgePlantType deleted successfully";
    }


    public String update(Long id, AgePlantTypeVO vO) {
        String validerror="";
        if (!(validerror=isValidation(vO)).equals("")){
            return "failed : "+"\n" +validerror;
        }
        AgePlantType bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        agePlantTypeRepository.save(bean);
        Gson gson=new Gson();
        return gson.toJson(vO);
    }

    public AgePlantTypeVO getById(Long id) {
        AgePlantType original = requireOne(id);
        return toVO(original);
    }

/*
    public Page<AgePlantTypeVO> query(AgePlantTypeQueryVO vO) {
        throw new UnsupportedOperationException();
    }
*/

    private AgePlantTypeVO toVO(AgePlantType original) {
        AgePlantTypeVO bean = new AgePlantTypeVO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AgePlantType requireOne(Long id) {
        return agePlantTypeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

   private String isValidation(AgePlantTypeVO vO) {
        String result="";
      
        return result;
    }
}
