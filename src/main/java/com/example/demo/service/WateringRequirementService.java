package com.example.demo.service;

import com.example.demo.entity.WateringRequirement;
import com.example.demo.repository.WateringRequirementRepository;
import com.example.demo.vo.WateringRequirementVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class WateringRequirementService {

    @Autowired
    private WateringRequirementRepository wateringRequirementRepository;

    public Long save(WateringRequirementVO vO) {
        WateringRequirement bean = new WateringRequirement();
        BeanUtils.copyProperties(vO, bean);
        bean = wateringRequirementRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        wateringRequirementRepository.deleteById(id);
    }

    public void update(Long id, WateringRequirementVO vO) {
        WateringRequirement bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        wateringRequirementRepository.save(bean);
    }

    public WateringRequirementVO getById(Long id) {
        WateringRequirement original = requireOne(id);
        return toVO(original);
    }

/*    public Page<WateringRequirementVO> query(WateringRequirementVO vO) {
        throw new UnsupportedOperationException();
    }*/

    private WateringRequirementVO toVO(WateringRequirement original) {
        WateringRequirementVO bean = new WateringRequirementVO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private WateringRequirement requireOne(Long id) {
        return wateringRequirementRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
