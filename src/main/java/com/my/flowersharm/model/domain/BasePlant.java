package com.my.flowersharm.model.domain;

public class BasePlant {
    private Long id;
    private String name;

    public BasePlant() {
    }

    public BasePlant(String name) {
        this.name = name;
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
