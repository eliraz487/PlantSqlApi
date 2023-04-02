package com.example.demo.service;

import com.example.demo.repository.PlantGroupRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PlantGroupService {

    @Autowired
    private PlantGroupRepository plantGroupRepository;

    public Long save(PlantGroupVO vO) {
        PlantGroup bean = new PlantGroup();
        BeanUtils.copyProperties(vO, bean);
        bean = plantGroupRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        plantGroupRepository.deleteById(id);
    }

    public void update(Long id, PlantGroupUpdateVO vO) {
        PlantGroup bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        plantGroupRepository.save(bean);
    }

    public PlantGroupDTO getById(Long id) {
        PlantGroup original = requireOne(id);
        return toDTO(original);
    }

    public Page<PlantGroupDTO> query(PlantGroupQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PlantGroupDTO toDTO(PlantGroup original) {
        PlantGroupDTO bean = new PlantGroupDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PlantGroup requireOne(Long id) {
        return plantGroupRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
