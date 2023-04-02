package com.example.demo.service;

import com.example.demo.repository.PlantTypeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    public void update(Long id, PlantTypeUpdateVO vO) {
        PlantType bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        plantTypeRepository.save(bean);
    }

    public PlantTypeDTO getById(Long id) {
        PlantType original = requireOne(id);
        return toDTO(original);
    }

    public Page<PlantTypeDTO> query(PlantTypeQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PlantTypeDTO toDTO(PlantType original) {
        PlantTypeDTO bean = new PlantTypeDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PlantType requireOne(Long id) {
        return plantTypeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
