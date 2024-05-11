package com.ventura.heroeservice.controllers;

import com.ventura.heroeservice.dto.HeroeDto;
import com.ventura.heroeservice.mappers.HeroeMapper;
import com.ventura.heroeservice.model.Heroe;
import com.ventura.heroeservice.model.Publisher;
import com.ventura.heroeservice.repositories.HeroeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"}, maxAge = 3600)
@RestController
@RequestMapping("/api/heroes")
public class HeroController {
    public final HeroeRepository heroeRepository;

    public HeroController(HeroeRepository heroeRepository) {
        this.heroeRepository = heroeRepository;
    }

    @GetMapping()
    public List<HeroeDto> getAll() {
        var heroes = heroeRepository.findAll();
        return heroes.stream().map(HeroeMapper::toHeroeDto).collect(Collectors.toList());
    }

    @PostMapping()
    public Heroe createHeroe(@RequestBody Heroe heroe) {
        return heroeRepository.save(heroe);
    }

    @PutMapping("/{id}")
    public HeroeDto updateHeroe(@RequestBody HeroeDto heroeDto) {
        var heroeEntity = HeroeMapper.toHeroe(heroeDto);

        var savedHeroe = heroeRepository.save(heroeEntity);

        return HeroeMapper.toHeroeDto(savedHeroe);

    }

    @PostMapping("/bulk")
    public List<Heroe> bulkHeroes(@RequestBody List<Heroe> heroeList) {
        return heroeRepository.saveAll(heroeList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HeroeDto> getById(@PathVariable Long id) {

        Optional<Heroe> heroeOptional = heroeRepository.findById(id);
//        if (heroeOptional.isPresent()){
//            return heroeOptional.get();
//        } else { return new Heroe();}

        return heroeOptional.map(heroe -> ResponseEntity.ok().body(HeroeMapper.toHeroeDto(heroeOptional.get()))).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));


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
