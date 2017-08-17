package com.my.flowersharm.model.domain;

/**
 * @author Oleksii Petrokhalko.
 */
public class Flower extends BasePlant {
    private Colour colour;
    private Freshness freshness;
    private Integer size;

    public Flower() {
    }

    public Flower(String name, Colour colour, Freshness freshness, Integer size) {
        super(name);
        this.colour = colour;
        this.freshness = freshness;
        this.size = size;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public Freshness getFreshness() {
        return freshness;
    }

    public void setFreshness(Freshness freshness) {
        this.freshness = freshness;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
