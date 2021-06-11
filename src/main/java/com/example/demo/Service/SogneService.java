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

import java.util.*;

@Service
public class SogneService {

    @Autowired
    SogneRepository sogneRepository;

    @Autowired
    KommuneRepository kommuneRepository;


    public Sogne create(SogneDTO sogneDTO){
        Optional<Kommune> kommune = kommuneRepository.findById(sogneDTO.getKommunekode());
        return sogneRepository.save(new Sogne(sogneDTO, kommune.get()));
    }

    public Set<Sogne> findAll(){
        Set<Sogne> sogneSet = new HashSet<>();
        for(Sogne sogne: sogneRepository.findAll()){
            sogneSet.add(sogne);
        }
        return sogneSet;
    }

    public Sogne findById(long id){
        Optional<Sogne> sogneOptional = sogneRepository.findById(id);
        if (!sogneOptional.isPresent()){
            throw new RuntimeException("Sogne: " + id + " sogne blev ikke fundet");
        } else {
            return sogneOptional.get();
        }
    }

    public Sogne update(SogneDTO sogneDTO) throws Exception {
        Iterator<Sogne> iterator = sogneRepository.findAll().iterator();
        while (iterator.hasNext()) {
            Sogne sogne = iterator.next();
            if(sogneDTO.getNavn() == sogne.getNavn()){
                return sogneRepository.save(sogne);
            }
        }
        throw new Exception("Kan ikke updatere");
    }

    public ResponseEntity<String> delete (long id){
        Optional<Sogne> optionalSogne = sogneRepository.findById(id);
        if (optionalSogne.isEmpty()){
            //Så findes id ikke
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{ 'msg' : id " + id + " not found'}");
        }
        //Ellers sletter jeg den her
        sogneRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("{ 'msg' : 'deleted'}");
    }

}
