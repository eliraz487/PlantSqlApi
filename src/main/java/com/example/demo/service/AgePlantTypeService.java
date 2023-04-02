package com.example.demo.service;

import com.example.demo.repository.AgePlantTypeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AgePlantTypeService {

    @Autowired
    private AgePlantTypeRepository agePlantTypeRepository;

    public Long save(AgePlantTypeVO vO) {
        AgePlantType bean = new AgePlantType();
        BeanUtils.copyProperties(vO, bean);
        bean = agePlantTypeRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        agePlantTypeRepository.deleteById(id);
    }

    public void update(Long id, AgePlantTypeUpdateVO vO) {
        AgePlantType bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        agePlantTypeRepository.save(bean);
    }

    public AgePlantTypeDTO getById(Long id) {
        AgePlantType original = requireOne(id);
        return toDTO(original);
    }

    public Page<AgePlantTypeDTO> query(AgePlantTypeQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AgePlantTypeDTO toDTO(AgePlantType original) {
        AgePlantTypeDTO bean = new AgePlantTypeDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AgePlantType requireOne(Long id) {
        return agePlantTypeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
