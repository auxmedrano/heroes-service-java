package com.ventura.heroeservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "publishers", schema = "public")
public class Publisher {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;
    private String name;

    public Publisher(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
