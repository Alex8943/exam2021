package com.example.demo.Controller;

import com.example.demo.Model.Sogne;
import com.example.demo.Model.SogneDTO;
import com.example.demo.Service.KommuneService;
import com.example.demo.Service.SogneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController // sender objecter i bestemt form
public class SogneRestCon {

    @Autowired
    SogneService sogneService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody SogneDTO sogneDTO){
        Sogne sogne1 = sogneService.create(sogneDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("{'msg' : 'created id' "+ sogne1.getId()+"}");
    }

    @GetMapping("/findAllSogne")
    public List<Sogne> findAll() {
        List<Sogne> sogneList = new ArrayList<>();
        sogneService.findAll().forEach(s->sogneList.add(s));
        return sogneList;
    }

    @PutMapping("/updateSogne/{id}")
    public Sogne update(@PathVariable("id") long id, @RequestBody Sogne sogne) throws Exception{
        //Sogne sogne1 = sogneService.create(sogneDTO);
        return sogneService.update(sogne, id);
    }

    @DeleteMapping("/deleteSogne/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id){
        return sogneService.delete(id);

    }



}
