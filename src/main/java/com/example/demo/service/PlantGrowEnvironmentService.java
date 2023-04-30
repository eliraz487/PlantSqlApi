package com.example.demo.service;

import com.example.demo.entity.PlantGrowEnvironment;
import com.example.demo.repository.PlantGrowEnvironmentRepository;
import com.example.demo.vo.PlantGrowEnvironmentVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public void update(Long id, PlantGrowEnvironmentVO vO) {
        PlantGrowEnvironment bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        plantGrowEnvironmentRepository.save(bean);
    }

    public PlantGrowEnvironmentVO getById(Long id) {
        PlantGrowEnvironment original = requireOne(id);
        return toVO(original);
    }

//    public Page<PlantGrowEnvironmentVO> query(PlantGrowEnvironmentQueryVO vO) {
//        throw new UnsupportedOperationException();
//    }

    private PlantGrowEnvironmentVO toVO(PlantGrowEnvironment original) {
        PlantGrowEnvironmentVO bean = new PlantGrowEnvironmentVO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PlantGrowEnvironment requireOne(Long id) {
        return plantGrowEnvironmentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }




    //findByNameAndUserOwnerID
    public ArrayList<PlantGrowEnvironment> findByNameAndUserOwnerID(Long ownerID){
        ArrayList<PlantGrowEnvironment> ownerplantGrowEnvironments=new ArrayList<>();
        ownerplantGrowEnvironments=plantGrowEnvironmentRepository.getAllUserPlantGrowEnvironment(ownerID);
        return ownerplantGrowEnvironments;
    }
// getAllUserPlantGrowEnvironment
    public PlantGrowEnvironment getByNameAndUserID(String name,Long ownerID){
        PlantGrowEnvironment plantGrowEnvironment=new PlantGrowEnvironment();
        plantGrowEnvironment =plantGrowEnvironmentRepository.findByNameAndUserOwnerID(name,ownerID);
        return plantGrowEnvironment;
    }
}
