package com.example.demo.service;

import com.example.demo.entity.AgePlantType;
import com.example.demo.repository.AgePlantTypeRepository;
import com.example.demo.vo.AgePlantTypeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AgePlantTypeService {

    @Autowired
    private  AgePlantTypeRepository agePlantTypeRepository;

    public AgePlantTypeService(AgePlantTypeRepository agePlantTypeRepository) {
        this.agePlantTypeRepository = agePlantTypeRepository;
    }

    public Long save(AgePlantTypeVO vO) {
        AgePlantType bean = new AgePlantType();
        BeanUtils.copyProperties(vO, bean);
        bean = agePlantTypeRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        agePlantTypeRepository.deleteById(id);
    }

    public void update(Long id, AgePlantTypeVO vO) {
        AgePlantType bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        agePlantTypeRepository.save(bean);
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
}
