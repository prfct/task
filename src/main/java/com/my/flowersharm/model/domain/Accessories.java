package com.my.flowersharm.model.domain;

/**
 * @author Oleksii Petrokhalko.
 */
public class Accessories {
    private Long id;
    private AccessoriesType type;

    public Accessories() {
    }

    public Accessories(AccessoriesType type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccessoriesType getType() {
        return type;
    }

    public void setType(AccessoriesType type) {
        this.type = type;
    }
}
