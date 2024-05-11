package com.ventura.heroeservice.dto;

import com.ventura.heroeservice.model.Heroe;

public class HeroeDto {
    private Long id;
    private String superhero;
    private String alterEgo;
    private String firstAppearance;
    private String characters;
    private String altImg;
    private Long publisherId;

//    public HeroeDto(Heroe heroe){
//        this.id = heroe.getId();
//        this.superhero = heroe.getSuperhero();
//        this.alterEgo = heroe.getAlterEgo();
//        this.firstAppearance = heroe.getFirstAppearance();
//        this.characters = heroe.getCharacters();
//        this.altImg = heroe.getAltImg();
//        this.publisherId = heroe.getPublisher().getId();
//    }


    public HeroeDto() {
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

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }
}
