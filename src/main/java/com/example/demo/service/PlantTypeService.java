package com.example.demo.service;

import com.example.demo.entity.PlantType;
import com.example.demo.repository.PlantTypeRepository;
import com.example.demo.vo.PlantTypeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PlantTypeService {

    @Autowired
    private PlantTypeRepository plantTypeRepository;

    public Long save(PlantTypeVO vO) {
        PlantType bean = new PlantType();
        BeanUtils.copyProperties(vO, bean);
        bean = plantTypeRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        plantTypeRepository.deleteById(id);
    }

    public void update(Long id, PlantTypeVO vO) {
        PlantType bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        plantTypeRepository.save(bean);
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
}
