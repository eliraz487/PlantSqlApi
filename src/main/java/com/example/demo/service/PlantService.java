package com.example.demo.service;

import com.example.demo.repository.PlantRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PlantService {

    @Autowired
    private PlantRepository plantRepository;

    public Long save(PlantVO vO) {
        Plant bean = new Plant();
        BeanUtils.copyProperties(vO, bean);
        bean = plantRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        plantRepository.deleteById(id);
    }

    public void update(Long id, PlantUpdateVO vO) {
        Plant bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        plantRepository.save(bean);
    }

    public PlantDTO getById(Long id) {
        Plant original = requireOne(id);
        return toDTO(original);
    }

    public Page<PlantDTO> query(PlantQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PlantDTO toDTO(Plant original) {
        PlantDTO bean = new PlantDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Plant requireOne(Long id) {
        return plantRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
