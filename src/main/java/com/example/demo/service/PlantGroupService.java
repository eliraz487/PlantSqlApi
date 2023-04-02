package com.example.demo.service;


import com.example.demo.entity.PlantGroup;
import com.example.demo.repository.PlantGroupRepository;
import com.example.demo.vo.PlantGroupVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public void update(Long id, PlantGroupVO vO) {
        PlantGroup bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        plantGroupRepository.save(bean);
    }

    public PlantGroupVO getById(Long id) {
        PlantGroup original = requireOne(id);
        return toVO(original);
    }

//    public Page<PlantGroupVO> query(PlantGroupQueryVO vO) {
//        throw new UnsupportedOperationException();
//    }

    private PlantGroupVO toVO(PlantGroup original) {
        PlantGroupVO bean = new PlantGroupVO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PlantGroup requireOne(Long id) {
        return plantGroupRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
    //getByNameAndPlantGrowEnvironmentID
    public PlantGroup getByNameAndPlantGrowEnvironmentID(String name,Long id){
        PlantGroup plantGroup=new PlantGroup();
        plantGroup=plantGroupRepository.getByNameAndPlantGrowEnvironmentID(name,id);
        return plantGroup;
    }
    //getAllPlantGroupByPlantGrowEnvironmentID

    public ArrayList<PlantGroup> getAllPlantGroupByPlantGrowEnvironmentID(Long id){
        ArrayList<PlantGroup> ownerPlantGroups=new ArrayList<>();
        ownerPlantGroups=plantGroupRepository.getAllPlantGroupByPlantGrowEnvironmentID(id);
        return ownerPlantGroups;
    }


}
