package com.example.demo.Service;

import com.example.demo.Model.Kommune;
import com.example.demo.Model.Sogne;
import com.example.demo.Model.SogneDTO;
import com.example.demo.Repository.KommuneRepository;
import com.example.demo.Repository.SogneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

@Service
public class KommuneService {
    @Autowired
    KommuneRepository kommuneRepository;

    @Autowired
    SogneRepository sogneRepository;


    public Kommune create(Kommune kommune){
        Optional<Sogne> sogne = sogneRepository.findById(kommune.getKommunekode());
        return kommuneRepository.save(new Kommune(kommune.getKommunekode(), sogne.toString()));
    }

    public Set<Kommune> findAll(){
        Set<Kommune> kommuneSet = new HashSet<>();
        for(Kommune kommune: kommuneRepository.findAll()){
            kommuneSet.add(kommune);
        }
        return kommuneSet;
    }

    public Kommune findById(long id){
        Optional<Kommune> kommuneOptional = kommuneRepository.findById(id);
        if (!kommuneOptional.isPresent()){
            throw new RuntimeException("Kommune: " + id + " blev ikke fundet");
        } else {
            return kommuneOptional.get();
        }
    }

    public Kommune update(SogneDTO sogneDTO) throws Exception {
        Iterator<Kommune> iterator = kommuneRepository.findAll().iterator();
        while (iterator.hasNext()) {
            Kommune kommune = iterator.next();
            if(sogneDTO.getKommunekode() == kommune.getKommunekode()){
                return kommuneRepository.save(kommune);
            }
        }
        throw new Exception("Kan ikke updatere");
    }

    public ResponseEntity<String> delete (long id){
        Optional<Kommune> optionalKommune = kommuneRepository.findById(id);
        if (optionalKommune.isEmpty()){
            //Så findes id ikke
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{ 'msg' : id " + id + " not found'}");
        }
        //Ellers sletter jeg den her
        kommuneRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("{ 'msg' : 'deleted'}");
    }

}
