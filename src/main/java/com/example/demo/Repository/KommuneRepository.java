package com.example.demo.Repository;

import com.example.demo.Model.Kommune;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KommuneRepository extends CrudRepository<Kommune, Long> {
}
