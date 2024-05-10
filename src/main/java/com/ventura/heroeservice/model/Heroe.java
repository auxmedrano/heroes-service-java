package com.ventura.heroeservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "heroes", schema = "public")
public class Heroe {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private String superhero;
    private String alterEgo;
    private String firstAppearance;
    private String characters;
    private String altImg;
    @ManyToOne
    @JoinColumn(name = "publisherId")
    private Publisher publisher;
    public Heroe(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSuperhero() {
        return superhero;
    }

    public void setSuperhero(String superhero) {
        this.superhero = superhero;
    }

    public String getAlterEgo() {
        return alterEgo;
    }

    public void setAlterEgo(String alterEgo) {
        this.alterEgo = alterEgo;
    }

    public String getFirstAppearance() {
        return firstAppearance;
    }

    public void setFirstAppearance(String firstAppearance) {
        this.firstAppearance = firstAppearance;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }

    public String getAltImg() {
        return altImg;
    }

    public void setAltImg(String altImg) {
        this.altImg = altImg;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
