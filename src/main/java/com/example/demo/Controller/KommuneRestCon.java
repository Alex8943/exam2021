package com.example.demo.Controller;

import com.example.demo.Model.Kommune;
import com.example.demo.Model.Sogne;
import com.example.demo.Model.SogneDTO;
import com.example.demo.Repository.KommuneRepository;
import com.example.demo.Service.KommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/kommune")
public class KommuneRestCon {

    @Autowired
    KommuneService kommuneService;


    @GetMapping("/findAllKommune")
    public List<Kommune> findAll(){
        List<Kommune> kommuneList = new ArrayList<>();
        kommuneService.findAll().forEach(s->kommuneList.add(s));
        return kommuneList;
    }


    @PostMapping("/createKommune")
    public ResponseEntity<String> create(@RequestBody Kommune kommune){
        Kommune newKommune = kommuneService.create(kommune);
        return ResponseEntity.status(HttpStatus.CREATED).body("{'msg' : 'created id' "+ newKommune.getKommunekode()+"}");
    }


    @PutMapping("/updateKommune")
    public Kommune update(@RequestBody SogneDTO sogneDTO) throws Exception{
        return kommuneService.update(sogneDTO);
    }

    @DeleteMapping("/deleteKommune/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id){
        return kommuneService.delete(id);

    }


}
