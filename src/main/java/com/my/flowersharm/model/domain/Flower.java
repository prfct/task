package com.my.flowersharm.model.domain;

/**
 * @author Oleksii Petrokhalko.
 */
public class Flower extends BasePlant {
    private Colour colour;
    private Freshness freshness;
    private Steam steam;

    public Flower() {
    }

    public Flower(String name, Colour colour, Freshness freshness, Steam steam) {
        super(name);
        this.colour = colour;
        this.freshness = freshness;
        this.steam = steam;
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

    public Steam getSteam() {
        return steam;
    }

    public void setSteam(Steam steam) {
        this.steam = steam;
    }
}
