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

    //Create a Sogne object
    public Sogne create(SogneDTO sogneDTO){
        Optional<Kommune> kommune = kommuneRepository.findById(sogneDTO.getKommunekode());
        return sogneRepository.save(new Sogne(sogneDTO, kommune.get()));
    }

    //Find all Sogne object
    public Set<Sogne> findAll(){
        Set<Sogne> sogneSet = new HashSet<>();
        for(Sogne sogne: sogneRepository.findAll()){
            sogneSet.add(sogne);
        }
        return sogneSet;
    }

    //Find one Sagne by id
    public Sogne findById(long id){
        Optional<Sogne> sogneOptional = sogneRepository.findById(id);
        if (!sogneOptional.isPresent()){
            throw new RuntimeException("Sogne: " + id + " sogne blev ikke fundet");
        } else {
            return sogneOptional.get();
        }
    }

    //Update a Sogne
    public Sogne update(Sogne sogne,long id) throws Exception {
        Iterator<Sogne> iterator = sogneRepository.findAll().iterator();
        while (iterator.hasNext()) {
            Sogne sogneIter = iterator.next();
            if(sogne.getSognekode() == sogneIter.getId()){
                ResponseEntity.status(HttpStatus.OK).body("{ 'msg' : navn " + sogneIter.getNavn() + "found'} ");
                return sogneRepository.save(sogne);
            }
        }
        throw new Exception("Kan ikke updatere");
    }

    //Delete a player
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
