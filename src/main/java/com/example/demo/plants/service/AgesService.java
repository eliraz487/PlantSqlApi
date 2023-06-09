package com.example.demo.plants.service;

import com.example.demo.plants.entity.Ages;
import com.example.demo.plants.repository.AgesRepository;
import com.example.demo.plants.vo.AgesVO;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AgesService {

    @Autowired
    private AgesRepository agesRepository;

    public synchronized String save(AgesVO vO) {
        String validerror="";
        if (!(validerror=isValidation(vO)).equals("")){
            return "failed : "+"\n" +validerror;
        }
        Ages bean = new Ages();
        BeanUtils.copyProperties(vO, bean);
        try {
            // code to save the entity
            bean = agesRepository.save(bean);
        } catch (DataIntegrityViolationException ex) {
            return "failed : "+"\n" +ex.getMessage();
        }
        vO.setId(bean.getId());
        Gson gson=new Gson();
        return gson.toJson(vO);
    }


    public String delete(Long id) {
        Optional<Ages> optionalEntity = agesRepository.findById(id);
        if (!optionalEntity.isPresent()) {
            return "Age not found";
        }
        agesRepository.delete(optionalEntity.get());
        return "Age deleted successfully";
    }

    public String update(Long id, AgesVO vO) {
        String validerror="";
        if (!(validerror=isValidation(vO)).equals("")){
            return "failed : "+"\n" +validerror;
        }
        Ages bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        agesRepository.save(bean);
        Gson gson=new Gson();
        return gson.toJson(vO);
    }

    public AgesVO getById(Long id) {
        Ages original = requireOne(id);
        return toVO(original);
    }

//    public Page<AgesVO> query(AgesQueryVO vO) {
//        throw new UnsupportedOperationException();
//    }

    private AgesVO toVO(Ages original) {
        AgesVO bean = new AgesVO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Ages requireOne(Long id) {
        return agesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

   private String isValidation(AgesVO vO) {
        String result="";
        if (vO.getName()==null|| vO.getName().equals(""))
        {
            return "the name can't be null";
        }
        return result;
    }

}
