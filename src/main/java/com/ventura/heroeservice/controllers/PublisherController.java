package com.ventura.heroeservice.controllers;

import com.ventura.heroeservice.model.Publisher;
import com.ventura.heroeservice.repositories.PublisherRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/publishers")
public class PublisherController {
    private final PublisherRepository publisherRepository;
    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }
    @GetMapping("")
    public List<Publisher> getAll(){
        return publisherRepository.findAll();
    }
}
