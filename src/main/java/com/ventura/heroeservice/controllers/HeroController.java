package com.ventura.heroeservice.controllers;

import com.ventura.heroeservice.model.Heroe;
import com.ventura.heroeservice.model.Publisher;
import com.ventura.heroeservice.repositories.HeroeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("hero")
public class HeroController {
    public final HeroeRepository heroeRepository;

    public HeroController(HeroeRepository heroeRepository) {
        this.heroeRepository = heroeRepository;
    }

    @GetMapping()
    public List<Heroe> getAll() {
        return heroeRepository.findAll();
    }

    @PostMapping()
    public Heroe createUser(@RequestBody Heroe heroe) {
        return heroeRepository.save(heroe);
    }

    @PutMapping()
    public Heroe updateUser(@RequestBody Heroe heroe) {
        return heroeRepository.save(heroe);
    }

    @PostMapping("/bulk")
    public List<Heroe> bulkHeroes(@RequestBody List<Heroe> heroeList) {
        return heroeRepository.saveAll(heroeList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Heroe> getById(@PathVariable Long id) {

        Optional<Heroe> heroeOptional = heroeRepository.findById(id);
//        if (heroeOptional.isPresent()){
//            return heroeOptional.get();
//        } else { return new Heroe();}

        return heroeOptional.map(heroe -> ResponseEntity.ok().body(heroe)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));


        //opcional sirve para solucionar el problema de null
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
//        Optional<Heroe> heroeOptional = heroeRepository.findById(id);
//        if (heroeOptional.isPresent()){
//            heroeRepository.deleteById(id);
//   return ResponseEntity.noContent().build();
//     } else { return ResponseEntity.notFound().build();}
//
//    }

        if (heroeRepository.existsById(id)) {
            heroeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
