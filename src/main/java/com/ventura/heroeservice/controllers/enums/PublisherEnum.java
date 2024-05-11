package com.ventura.heroeservice.controllers.enums;

import java.util.Objects;

public enum PublisherEnum {
    DC(1L, "DC Comics"),
    MARVEL(2L,"Marvel Comics");

    private Long id;
    private String name;

    PublisherEnum(Long id, String name) {
        this.id = id;
        this.name = name;

    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public static PublisherEnum getById(Long id) {
        for (PublisherEnum publisherEnum : PublisherEnum.values()) {
            if (Objects.equals(publisherEnum.getId(), id)) {
                return publisherEnum;
            }
        }
        return null;
    }
}
