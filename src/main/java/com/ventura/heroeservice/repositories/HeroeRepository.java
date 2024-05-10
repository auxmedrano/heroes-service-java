package com.ventura.heroeservice.repositories;

import com.ventura.heroeservice.model.Heroe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HeroeRepository extends JpaRepository<Heroe, Long> {
    
}
