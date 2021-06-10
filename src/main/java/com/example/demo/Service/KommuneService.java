package com.example.demo.Service;

import com.example.demo.Model.Kommune;
import com.example.demo.Repository.KommuneRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class KommuneService {

    @Autowired
    KommuneRepository kommuneRepository;

    /*
    Object create();
    Set<Object> findKommuneById(long id);
    List<Object> findAllKommune();
    void update(Object o);
    void deleteById (long id);
     */

    Kommune create(Kommune kommune){
        return kommuneRepository.save(kommune);
    }

    public Set<Kommune> findAllKommune(){
        Set<Kommune> kommuneSet = new HashSet<>();
        for(Kommune kommune : kommuneRepository.findAll()){
            kommuneSet.add(kommune);
        }
        return kommuneSet;
    }

    public Kommune findKommuneById(long id){
        Optional<Kommune> optionalKommune = kommuneRepository.findById(id);
        if (!optionalKommune.isPresent()){
            throw new RuntimeException("Kommune : " + id + " Kommune blev ikke fundet");
        } else {
            return optionalKommune.get();
        }
    }

    public Kommune update(Kommune kommune){
        return kommuneRepository.save(kommune);
    }

    public void deleteById (long id){
        kommuneRepository.deleteById(id);
    }

    public boolean checkIfKommuneExist(long id) throws NotFoundException {
        boolean checkIfExist = kommuneRepository.existsById(id);
        boolean status = false;
        if (!checkIfExist){
            throw new NotFoundException("Kommune dosent exist: " + id);
        } else {
            return status = true;
        }
    }

}
