package com.example.demo.service;

import com.example.demo.repository.AgesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AgesService {

    @Autowired
    private AgesRepository agesRepository;

    public Long save(AgesVO vO) {
        Ages bean = new Ages();
        BeanUtils.copyProperties(vO, bean);
        bean = agesRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        agesRepository.deleteById(id);
    }

    public void update(Long id, AgesUpdateVO vO) {
        Ages bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        agesRepository.save(bean);
    }

    public AgesDTO getById(Long id) {
        Ages original = requireOne(id);
        return toDTO(original);
    }

    public Page<AgesDTO> query(AgesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AgesDTO toDTO(Ages original) {
        AgesDTO bean = new AgesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Ages requireOne(Long id) {
        return agesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
