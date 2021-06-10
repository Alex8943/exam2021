package com.example.demo.Service;

import com.example.demo.Model.Kommune;
import com.example.demo.Model.Sogne;
import com.example.demo.Repository.SogneRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class SogneService {
     /*
      void create();
    long findKommuneById(long id);
    List<Kommune> findAllKommune();
    void update(long id);
    void delete (long id);
     */

    @Autowired
    SogneRepository sogneRepository;

    public Sogne create(Sogne sogne){
        return sogneRepository.save(sogne);
    }
    public Set<Sogne> findAllKommune(){
        Set<Sogne> sogneSet = new HashSet<>();
        for(Sogne sogne: sogneRepository.findAll()){
            sogneSet.add(sogne);
        }
        return sogneSet;
    }

    public Sogne findKommuneById(long id){
        Optional<Sogne> sogneOptional = sogneRepository.findById(id);
        if (!sogneOptional.isPresent()){
            throw new RuntimeException("Sogne: " + id + " sogne blev ikke fundet");
        } else {
            return sogneOptional.get();
        }
    }

    public Sogne update(Sogne sogne){
        return sogneRepository.save(sogne);
    }

    public void delete (long id){
        sogneRepository.deleteById(id);
    }

    public boolean checkIfSogneExist(long id) throws NotFoundException {
        boolean checkIfExist = sogneRepository.existsById(id);
        boolean status = false;
        if (!checkIfExist){
            throw new NotFoundException("Sogne dosent exist : " + id);
        } else {
            return status = true;
        }
    }
}
