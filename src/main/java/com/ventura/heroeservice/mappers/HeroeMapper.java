package com.ventura.heroeservice.mappers;

import com.ventura.heroeservice.controllers.enums.PublisherEnum;
import com.ventura.heroeservice.dto.HeroeDto;
import com.ventura.heroeservice.model.Heroe;
import com.ventura.heroeservice.model.Publisher;

public class HeroeMapper {

    public static Heroe toHeroe(HeroeDto heroeDto) {
        Heroe heroe = new Heroe();
        heroe.setId(heroeDto.getId());
        heroe.setSuperhero(heroeDto.getSuperhero());
        heroe.setAlterEgo(heroeDto.getAlterEgo());
        heroe.setFirstAppearance(heroeDto.getFirstAppearance());
        heroe.setCharacters(heroeDto.getCharacters());
        heroe.setAltImg(heroeDto.getAltImg());

        PublisherEnum publisherEnum = PublisherEnum.getById(heroeDto.getPublisherId());
        if (publisherEnum != null) {
            heroe.setPublisher(new Publisher(publisherEnum.getId(), publisherEnum.getName()));
        }

        return heroe;
    }

    public static HeroeDto toHeroeDto(Heroe heroe) {
        HeroeDto heroeDto = new HeroeDto();
        heroeDto.setId(heroe.getId());
        heroeDto.setSuperhero(heroe.getSuperhero());
        heroeDto.setAlterEgo(heroe.getAlterEgo());
        heroeDto.setFirstAppearance(heroe.getFirstAppearance());
        heroeDto.setCharacters(heroe.getCharacters());
        heroeDto.setAltImg(heroe.getAltImg());
        heroeDto.setPublisherId(heroe.getPublisher().getId());
        return heroeDto;
    }
}
