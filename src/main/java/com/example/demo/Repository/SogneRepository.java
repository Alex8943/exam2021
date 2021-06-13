package com.example.demo.Repository;

import com.example.demo.Model.Sogne;
import com.example.demo.Model.SogneDTO;
import org.springframework.data.repository.CrudRepository;

public interface SogneRepository extends CrudRepository<Sogne, Long> {
    //Every crud method will now return a sogne obejct, and the primary key is a type long
}
