package com.example.demo.service;

import com.example.demo.repository.PlantGrowEnvironmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PlantGrowEnvironmentService {

    @Autowired
    private PlantGrowEnvironmentRepository plantGrowEnvironmentRepository;

    public Long save(PlantGrowEnvironmentVO vO) {
        PlantGrowEnvironment bean = new PlantGrowEnvironment();
        BeanUtils.copyProperties(vO, bean);
        bean = plantGrowEnvironmentRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        plantGrowEnvironmentRepository.deleteById(id);
    }

    public void update(Long id, PlantGrowEnvironmentUpdateVO vO) {
        PlantGrowEnvironment bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        plantGrowEnvironmentRepository.save(bean);
    }

    public PlantGrowEnvironmentDTO getById(Long id) {
        PlantGrowEnvironment original = requireOne(id);
        return toDTO(original);
    }

    public Page<PlantGrowEnvironmentDTO> query(PlantGrowEnvironmentQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PlantGrowEnvironmentDTO toDTO(PlantGrowEnvironment original) {
        PlantGrowEnvironmentDTO bean = new PlantGrowEnvironmentDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PlantGrowEnvironment requireOne(Long id) {
        return plantGrowEnvironmentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
